package com.project.notifications.controller;

import com.project.notifications.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    @SendTo("/all/messages")
    @MessageMapping("/application")
    public Message send(final Message message) {
        return message;
    }

    @MessageMapping("/admin")
    public void sendToSpecificUser(final @Payload Message message) {
        messagingTemplate.convertAndSendToUser(message.getTo(), "/admin", message);
    }
}