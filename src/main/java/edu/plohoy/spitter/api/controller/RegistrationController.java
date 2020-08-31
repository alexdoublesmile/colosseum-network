package edu.plohoy.spitter.api.controller;

import edu.plohoy.spitter.api.domain.Role;
import edu.plohoy.spitter.api.domain.User;
import edu.plohoy.spitter.api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Resource(name="user service")
    private UserService service;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDB = service.findByUsername(user.getUserName());

        if(userFromDB != null) {
            model.put("message", "User is exists!");
            return "/registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        service.save(user);

        return "redirect:/login";
    }
}
