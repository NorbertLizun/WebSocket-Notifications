package com.project.notifications.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketMessageBrokerConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry brokerRegistry) {
        brokerRegistry.enableSimpleBroker("/all", "/admin");
        brokerRegistry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry endpointRegistry) {
        endpointRegistry.addEndpoint("/ws").withSockJS();
    }
}
