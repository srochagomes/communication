package infraestructure.route

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import infraestructure.dto.entry.Message
import infraestructure.dto.enum.DomainType
import infraestructure.dto.enum.MessageType
import jakarta.enterprise.context.ApplicationScoped
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.jackson.JacksonDataFormat
import org.eclipse.microprofile.config.inject.ConfigProperty


@ApplicationScoped
class CamelRoute(
    @ConfigProperty(name = "static_content_path") private val staticContentPath: String
): RouteBuilder() {

    override fun configure() {
        val jacksonDataFormat = JacksonDataFormat(Message::class.java)
        jacksonDataFormat.addModule(JavaTimeModule())
        from("{{events.origin.user-auth-created}}")
            .routeId("SEND_EMAIL")
            .routeDescription("Send email")
            .unmarshal(jacksonDataFormat)
            .log("mensagem recebida de RabbitMQ: \${body}")
            .choice()
            .`when`(jsonpath("$.type").isEqualTo(constant(MessageType.EMAIL)))
                .log("String-template: \${body}")
                .setHeader("To",  jsonpath("$.specification.detail.emailTo"))
                .setHeader("From", constant("gomblesolutions@gmail.com"))
                .setHeader("Subject", jsonpath("$.specification.domainType").convertTo(DomainType::class.java).method("description"))
                .setHeader("pathStaticContentImage", constant(staticContentPath))
                .to("freemarker://email/welcome_and_confirm.ftl")
                .setBody(simple("\${body}"))
                .setHeader("Content-Type", constant("text/html"))
                .to("{{events.destiny.command-send-email}}")
            .otherwise()
                .log("mensagem não processada recebida de RabbitMQ: \${body}")
            .end()
    }




}