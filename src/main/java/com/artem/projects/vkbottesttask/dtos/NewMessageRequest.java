package com.artem.projects.vkbottesttask.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMessageRequest {
    private Message message;

    @JsonProperty("client_info")
    private ClientInfo clientInfo;
}
