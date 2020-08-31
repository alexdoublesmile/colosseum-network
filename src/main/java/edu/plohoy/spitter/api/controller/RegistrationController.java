package edu.plohoy.spitter.api.controller;

import edu.plohoy.spitter.api.domain.User;
import edu.plohoy.spitter.api.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class RegistrationController {

    @Resource(name="message service")
    private MessageService service;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

//    @PostMapping("/registration")
//    public String addUser(User user, Map<String, Object> model) {
//
//        return "login";
//    }
}
