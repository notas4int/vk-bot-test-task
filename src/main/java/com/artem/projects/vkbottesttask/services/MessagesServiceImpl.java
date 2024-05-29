package com.artem.projects.vkbottesttask.services;

import com.artem.projects.vkbottesttask.dtos.Message;
import com.artem.projects.vkbottesttask.dtos.MessageResponse;
import com.artem.projects.vkbottesttask.dtos.events.EventRequest;
import com.artem.projects.vkbottesttask.utils.RestResponseSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j2
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService {
    @Value("${vk.api.secret}")
    private String secret;

    private final RestResponseSender responseSender;

    @Override
    public void changeEnteredMsg(EventRequest eventRequest) {
        if (!eventRequest.getSecret().equals(secret)) {
            log.error("The secret key was entered incorrectly");
            return;
        }

        Message message = eventRequest.getEvent().getMessage();

        log.info(message);

        int userId = message.getFromId();
        int randomId = LocalDateTime.now().getSecond() + message.getFromId() + ThreadLocalRandom.current().nextInt(1, Short.MAX_VALUE);
        String messageTxt = "Your words - " + message.getText();

        MessageResponse msgResponse = new MessageResponse(
                userId,
                randomId,
                messageTxt
        );

        log.info(msgResponse.toString());

        responseSender.sendMsg(msgResponse);
    }
}
