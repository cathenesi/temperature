package org.asofth.iot.temperature.configuration;

import java.util.Map;

import org.asofth.iot.temperature.service.EventPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSocketMessageBroker
@Slf4j
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	@Autowired
	private EventPublisherService service;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/listener")
		.setAllowedOrigins("*")
//		.addInterceptors(new HandshakeInterceptor() {
//
//			@Override
//			public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
//					WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//				return false;
//			}
//
//			@Override
//			public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
//					WebSocketHandler wsHandler, Exception exception) {
//				try {
//					service.start();
//				} catch (Exception e) {
//					log.error("erro starting", e);
//				}
//			}
//
//		})
		.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

}