package com.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Object getQdetails(@RequestBody QueueRequest queueRequest) {
		return template.convertSendAndReceive(queueRequest.getQueueName(), queueRequest.getPayload());
	}
	
	@RabbitListener(queues= {"test"})
	private void getQueueNames(Message<Object> message) {
		log.info("Message From Q: " + message.getPayload());
	}
	
	


}
