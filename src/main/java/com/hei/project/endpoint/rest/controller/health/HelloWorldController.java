package com.hei.project.endpoint.rest.controller.health;


import com.hei.project.mail.Email;
import com.hei.project.mail.Mailer;
import com.hei.project.service.HelloWorldService;
import jakarta.mail.internet.InternetAddress;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;
    private final Mailer mailer;

    @GetMapping("/hello")
    @SneakyThrows
    public String hello(@RequestParam String to) {
        var email = new Email(new InternetAddress(to), List.of(), List.of(), "Hello world", "hellooooooo .... world!", List.of());
        mailer.accept(email);
        return "...world!";
    }

}
