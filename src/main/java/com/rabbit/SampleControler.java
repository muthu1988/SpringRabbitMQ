package com.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="rabbitmq")
public class SampleControler {
	
	@Autowired
	RabbitTemplate template;
	
	@GetMapping
	private String getQdetails() {
		template.convertAndSend("test", "testing the Q");
		return "details";
	}


}
