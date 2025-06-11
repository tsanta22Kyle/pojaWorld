package com.hei.project.endpoint.rest.controller.health;


import com.hei.project.service.HelloWorldService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return helloWorldService.uploadHelloWorldMessage(name);
    }

}
