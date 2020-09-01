package edu.plohoy.spitter.api.controller;

import edu.plohoy.spitter.api.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping
    public String userList() {
        return "userList";
    }
}
