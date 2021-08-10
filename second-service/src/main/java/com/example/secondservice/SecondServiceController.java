package com.example.secondservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
@Slf4j // log4j extend edition
public class SecondServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Second Service.";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("second-header") String header) {
        log.info("Request Header={}",header);
        log.info(String.format("Request Header=%s", header)); // %s -> 가변 파라미터
        // ("Request Header="+ String) 을 사용하는 방식은 String 객체를 계속해서 생성하기 때문에 메모리적 낭비가 심각하고, 직관적이지 못하다.
        return "Hello, Second service";
    }
}
