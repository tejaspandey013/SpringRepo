package com.springbootjms.application.consumer;

import org.springframework.stereotype.Component;

@Component
public class JmsListener {

	@org.springframework.jms.annotation.JmsListener(destination = "standalone.queue")
	public void consume(String message) {
		System.out.println("message consumed from queue "+message);
	}
}
