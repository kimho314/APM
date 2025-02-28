package com.example.tracing.controller;

import com.example.tracing.domain.Member;
import com.example.tracing.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.ResponseSpec;

@Slf4j
@RestController
@RequestMapping(value = "/members")
public class ControllerV3 {
    private final MemberService memberService;
    private final RestClient restClient;

    public ControllerV3(MemberService memberService, RestClient.Builder clientBuilder) {
        this.memberService = memberService;
        this.restClient = clientBuilder.baseUrl("http://localhost:8081").build();
    }

    @GetMapping("/create-event")
    public String createEvent() throws InterruptedException {
        Thread.sleep(1);
        ResponseSpec response = restClient.post().uri("/members/create").retrieve();
        log.info("response = {}", response.body(String.class));
        return "create-event";
    }

    @PostMapping("/create")
    public String create(){
        log.info("starts member create");
        memberService.save(new Member("test1", "1234!@#$"));
        return "create success";
    }
}
