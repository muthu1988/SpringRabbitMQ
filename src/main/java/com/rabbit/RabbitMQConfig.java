package com.rabbit;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	RabbitTemplate template(ConnectionFactory connectionFactory) {
		return new RabbitTemplate(connectionFactory);
	}

}
