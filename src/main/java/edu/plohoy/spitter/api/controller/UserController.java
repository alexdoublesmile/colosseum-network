package edu.plohoy.spitter.api.controller;

import edu.plohoy.spitter.api.dao.UserRepository;
import edu.plohoy.spitter.api.domain.Role;
import edu.plohoy.spitter.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
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
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PostMapping
    public String saveUser(
            @RequestParam("userId") User user,
            @RequestParam String username,
            @RequestParam Map<String, String> form) {

        user.setUsername(username);
        user.getRoles().clear();

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        repo.save(user);
        return "redirect:/user";
    }
}
