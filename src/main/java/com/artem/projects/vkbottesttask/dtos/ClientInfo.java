package com.artem.projects.vkbottesttask.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfo {
    @JsonProperty("button_actions")
    private String[] buttonActions;

    @JsonProperty("InlineKeyboard")
    private boolean inlineKeyboard;

    @JsonProperty("lang_id")
    private int langId;
}
