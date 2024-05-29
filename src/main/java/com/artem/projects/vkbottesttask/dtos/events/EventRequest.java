package com.artem.projects.vkbottesttask.dtos.events;

import com.artem.projects.vkbottesttask.dtos.NewMessageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
     private String type;

     @JsonProperty("event_id")
     private String event_id;

     @JsonProperty("group_id")
     private long groupId;

     private String secret;

     private String v;

     @JsonProperty("object")
     private NewMessageRequest event;
}
