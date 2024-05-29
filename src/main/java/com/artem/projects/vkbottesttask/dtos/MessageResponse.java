package com.artem.projects.vkbottesttask.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("random_id")
    private int randomId;

    private String message;
}
