package com.FindMyRoom.controller;

import com.FindMyRoom.dto.request.MessageRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
    @SendTo("/topic/messages")
    @MessageMapping("/application")
    public MessageRequest create(@NotNull final MessageRequest message) {
        System.out.println(message);
        return message;
    }

    @SendTo("/topic/guess")
    @MessageMapping("/get")
    public MessageRequest getMessage(@NotNull final MessageRequest message) {
        System.out.println(message);
        return message;
    }
}
