package com.example.tracing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.ResponseSpec;

@Slf4j
@RestController
@RequestMapping(value = "/hello")
public class ControllerV2 {

    private final RestClient restClient;

    public ControllerV2(RestClient.Builder clientBuilder) {
        restClient = clientBuilder.baseUrl("http://localhost:8081").build();
    }

    @GetMapping(value = "/path1")
    public String path1() throws InterruptedException {
        Thread.sleep(1);
        ResponseSpec response = restClient.get().uri("/hello/path2").retrieve();
        log.info("response = {}", response.body(String.class));
        return "hello path1";
    }

    @GetMapping(value = "/path2")
    public String path2() throws InterruptedException {
        Thread.sleep(2);
        return "hello path2";
    }
}
