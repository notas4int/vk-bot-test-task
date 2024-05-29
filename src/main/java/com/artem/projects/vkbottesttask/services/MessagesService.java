package com.artem.projects.vkbottesttask.services;

import com.artem.projects.vkbottesttask.dtos.events.EventRequest;

public interface MessagesService {
    void changeEnteredMsg(EventRequest eventRequest);
}
