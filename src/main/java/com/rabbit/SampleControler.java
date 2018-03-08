package com.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="rabbitmq")
public class SampleControler {
	
	private static final Logger log = LoggerFactory.getLogger(SampleControler.class);

	@Autowired
	RabbitTemplate template;
	
	@PostMapping
	private void getQdetails(@RequestBody QueueRequest queueRequest) {
		template.convertAndSend(queueRequest.getQueueName(), queueRequest.getPayload());
	}
	
	@RabbitListener(queues= RabbitMQConfig.QUEUE_NAME)
	private void consumer(Message<Object> message) {
		log.info("Message From Q: " + message.getPayload());
		// Uncomment below Line For dead Letter testing
		// throw new AmqpException("wantedly rejected this msg");
	}
	
//	@RabbitListener(queues= RabbitMQConfig.DEAD_LETTER_QUEUE_NAME)
//	private void deadLetterConsumer(Message<Object> message) {
//		log.info("Message From Dead Q: " + message.getPayload());
//	}
	
}
