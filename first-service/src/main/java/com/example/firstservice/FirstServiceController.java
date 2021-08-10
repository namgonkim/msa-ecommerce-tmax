package com.example.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {

    // @Value("local.server.port")
    // private String serverPort;

    Environment env;

    @Autowired
    public FirstServiceController(Environment env) {
        this.env = env;
    }

    // GET http://localhost:8081/first-service/welcome
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the First Service.";
    }

    // GET http://localhost:8081/first-service/welcome
    @GetMapping("/message")
    public String message(@RequestHeader(value = "first-request", required = true) String header) {
        System.out.println(header);
        return "Hello, First service";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());

        return String.format("Hi, This is First Service on PORT %s", env.getProperty("local.server.port"));
    }
}
