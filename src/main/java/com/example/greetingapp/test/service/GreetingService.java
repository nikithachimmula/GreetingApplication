package com.example.greetingapp.test.service;

import com.example.greetingapp.test.model.Greeting;
import com.example.greetingapp.test.model.User;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {

    private static final String template = "Hello Nikitha";
    private final AtomicLong counter = new AtomicLong();


    @Override
    public Greeting sayHello() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    public String sayPostHello(User user){
        return "Hello Ms  " +user.getFirstName()+" "+user.getLastName()+ "!";
    }

}
