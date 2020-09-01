package edu.plohoy.spitter.controller;

import edu.plohoy.spitter.domain.User;
import edu.plohoy.spitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserService service;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        if (!service.addUser(user)) {
            model.put("message", "User is already exists!");
            return "registration";
        }

        return "redirect:/login";
    }
}
