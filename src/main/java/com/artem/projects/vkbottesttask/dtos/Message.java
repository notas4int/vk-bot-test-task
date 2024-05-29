package com.artem.projects.vkbottesttask.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int id;

    private long date;

    @JsonProperty("peer_id")
    private int peerId;

    @JsonProperty("from_id")
    private int fromId;

    private String text;
}
