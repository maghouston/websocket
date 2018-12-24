package com.boraji.tutorial.spring.websocket;

import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MyWebSocketHandler extends TextWebSocketHandler {

	
	@Autowired
	private Consumer consumer;
	
	@Override
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		
		session.sendMessage(new TextMessage("allo allo "));
		Thread.sleep(1000);
		String clientMessage = message.getPayload();

		if (clientMessage.startsWith("Hello") || clientMessage.startsWith("Hi")) {
			for (int i = 0; i < 10; i++) {
				session.sendMessage(new TextMessage(i + ""));
				Thread.sleep(1000);
			}
			session.sendMessage(new TextMessage("Hello! What can i do for you?"));

		} else {
			session.sendMessage(new TextMessage(
					"This is a simple hello world example of using Spring WebSocket."));
		}
	}
}