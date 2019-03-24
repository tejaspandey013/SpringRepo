package com.springbootjms.application.producer;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {
	private static Logger log=LoggerFactory.getLogger(ProducerResource.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue queue;
	
	@GetMapping("/{message}")
	public String message(@PathVariable("message")final String message) {
		log.info("inside publish method");
		jmsTemplate.convertAndSend(queue,message);
		log.info("message published to queue");
		return "Published successfully"; 
	}
	
}
