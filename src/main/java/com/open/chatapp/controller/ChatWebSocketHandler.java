package com.open.chatapp.controller;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler{
	private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
	
	private static String example = "";
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		sessions.add(session);
		System.out.println("New Connection: " + session.getId());
	}
	
	@Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		example += message.getPayload() + "\n";
		TextMessage textMsg = new TextMessage(example);
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(textMsg);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println("Connection closed: " + session.getId());
    }

}
