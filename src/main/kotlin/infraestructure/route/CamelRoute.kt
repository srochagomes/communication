package infraestructure.route

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import jakarta.enterprise.context.ApplicationScoped
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.jackson.JacksonDataFormat
import org.apache.camel.component.mail.MailMessage


@ApplicationScoped
class CamelRoute(): RouteBuilder() {
    override fun configure() {
        val jacksonDataFormat = JacksonDataFormat(Any::class.java)
        jacksonDataFormat.addModule(JavaTimeModule())
        from("{{events.origin.user-auth-created}}")
            .routeId("SEND_EMAIL")
            .routeDescription("Send email")
            .unmarshal(jacksonDataFormat)
            .log("Enviando mensagem para o RabbitMQ: \${body}")

            .log("String-template: \${body}")
            .setHeader("To", jsonpath("$.email"))
            .setHeader("From", constant("gomblesolutions@gmail.com"))
            .setHeader("Subject", constant("Assunto do e-mail"))
            .to("freemarker://email/welcome_and_confirm.ftl")
            .setBody(simple("\${body}"))
            .setHeader("Content-Type", constant("text/html"))
            .to("smtps://smtp.gmail.com:465?username=gomblesolutions@gmail.com&password=lqxmahblswywlgek&" +
                    "subject=Test&mail.smtp.auth=false&mail.smtp.starttls.enable=true")
            .end()
    }




}