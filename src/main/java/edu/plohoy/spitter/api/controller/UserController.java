package edu.plohoy.spitter.api.controller;

import edu.plohoy.spitter.api.dao.UserRepository;
import edu.plohoy.spitter.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", repo.findAll());

        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);

        return "userEdit";
    }
}
