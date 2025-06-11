package com.hei.project.endpoint.rest.controller.health;


import com.hei.project.endpoint.event.EventProducer;
import com.hei.project.endpoint.event.model.SendEmailRequested;
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
    private final EventProducer eventProducer;

    @GetMapping("/hello")
    @SneakyThrows
    public String helloWorld(@RequestParam String to) {
        var event = SendEmailRequested.builder().to(to).build();
        eventProducer.accept(List.of(event));
        return "... world!";
    }

}
