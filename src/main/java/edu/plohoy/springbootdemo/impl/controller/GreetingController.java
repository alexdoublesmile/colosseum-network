package edu.plohoy.springbootdemo.impl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String getGreeting() {
        return "greeting";
    }
}
