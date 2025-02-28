package com.example.tracing.controller;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ControllerV1 {
    @GetMapping("/status")
    public String status(){
        anotherMethod();
        return "OK";
    }

    @WithSpan(value = "Controller.anotherMethod")
    public void anotherMethod() {
        log.info("anotherMethod invoked");
    }
}
