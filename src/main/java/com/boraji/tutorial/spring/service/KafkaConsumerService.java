package com.boraji.tutorial.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
	
	@Autowired
	SimpMessagingTemplate template;

	@KafkaListener(id="toto", topics = "test")
	public void consume(@Payload String message) {

		template.convertAndSend("/topic/temperature", message);

	}

}