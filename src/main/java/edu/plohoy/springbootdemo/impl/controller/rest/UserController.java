package edu.plohoy.springbootdemo.impl.controller.rest;

import edu.plohoy.springbootdemo.api.domain.User;
import edu.plohoy.springbootdemo.api.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @GetMapping({"/user_list", "users" +
            ""})
    public List<User> getUsers() {
        return Collections.singletonList(new User() {
            {
            setId(1L);
            setName("Ivan");
            }
        });

    }
}
