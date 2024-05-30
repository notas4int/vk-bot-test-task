package com.artem.projects.vkbottesttask.controllers;

import com.artem.projects.vkbottesttask.dtos.events.EventRequest;
import com.artem.projects.vkbottesttask.services.MessagesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vk-bot")
@Log4j2
public class BotMessageController {
    private final MessagesService messagesService;

    @PostMapping("/send-message")
    public String receiveAndSendMessage(@RequestBody EventRequest eventRequest) {
        log.info(eventRequest.toString());

        messagesService.changeEnteredMsg(eventRequest);
        return "ok";
    }
}
