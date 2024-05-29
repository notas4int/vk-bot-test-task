package com.artem.projects.vkbottesttask.utils;

import com.artem.projects.vkbottesttask.dtos.MessageResponse;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
@Log4j2
public class RestResponseSender {
    @Value("${vk.api.secret-token}")
    private String vkApiToken;

    @Value("${vk.api.version}")
    private String vkApiVersion;
    RestTemplate restTemplate = new RestTemplate();
    @SneakyThrows
    public void sendMsg(MessageResponse msgResponse) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("user_id", msgResponse.getUserId())
                .queryParam("random_id", msgResponse.getRandomId())
                .queryParam("access_token", vkApiToken)
                .queryParam("v", vkApiVersion)
                .queryParam("message", URLEncoder.encode(msgResponse.getMessage(), StandardCharsets.UTF_8))
                .toUriString();
        log.info(url);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(HttpHeaders.CONTENT_TYPE, "text/plain;charset=UTF-8");
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        log.info(response.getBody());
    }
}
