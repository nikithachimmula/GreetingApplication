package com.example.greetingapp.test.controller;

import com.example.greetingapp.test.model.Greeting;
import com.example.greetingapp.test.model.User;
import com.example.greetingapp.test.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("greeting/service")
    public Greeting greeting() {
        Greeting response = greetingService.sayHello();
        return response;
    }

    @PostMapping("/greeting01")
    public String greeting01(@RequestBody User user) {
        String newUser;
        newUser = greetingService.sayPostHello(user);
        return newUser;
    }
}