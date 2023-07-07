package infraestructure.config

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory


class RabbitMQConfig {
    @ApplicationScoped
    fun  connectionFactory(@ConfigProperty(name = "host_rabbit") host: String,
                           @ConfigProperty(name = "user_rabbit") port: String,
                           @ConfigProperty(name = "pass_rabbit") username: String,
                           @ConfigProperty(name = "port_rabbit") pwd: String,
    ): ConnectionFactory {
        val connectionFactory: CachingConnectionFactory = CachingConnectionFactory()
        connectionFactory.host = "192.168.15.103"
        connectionFactory.port = 5672
        connectionFactory.username = "api"
        connectionFactory.setPassword("api@user")
        return connectionFactory
    }
}