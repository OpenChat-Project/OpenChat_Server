package com.open.chatapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.open.chatapp.controller.ChatWebSocketHandler;

@Configuration
@EnableWebSocket
public class ChatWebSocketConfig implements WebSocketConfigurer{
	
	private final ChatWebSocketHandler handler;

    public ChatWebSocketConfig(ChatWebSocketHandler handler) {
        this.handler = handler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(handler, "/ws/chat")
                .setAllowedOrigins("*");
    }

}
