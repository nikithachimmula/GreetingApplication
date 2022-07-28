package com.example.greetingapp.test.service;
import com.example.greetingapp.test.model.Greeting;
import com.example.greetingapp.test.model.User;

public interface IGreetingService {

    Greeting sayHello();
    String sayPostHello(User user);
}
