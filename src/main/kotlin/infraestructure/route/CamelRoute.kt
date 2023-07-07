package infraestructure.route

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import jakarta.enterprise.context.ApplicationScoped
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.component.jackson.JacksonDataFormat
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory

@ApplicationScoped
class CamelRoute(): RouteBuilder() {
    override fun configure() {
        val jacksonDataFormat = JacksonDataFormat(Any::class.java)
        jacksonDataFormat.addModule(JavaTimeModule())
        fromF("{{events.origin.user-auth-created}}")
            .log("Enviando mensagem para o RabbitMQ: \${body}")
    }




}