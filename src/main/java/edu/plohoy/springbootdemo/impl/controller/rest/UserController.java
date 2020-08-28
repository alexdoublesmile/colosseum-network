package edu.plohoy.springbootdemo.impl.controller.rest;

import edu.plohoy.springbootdemo.api.dao.UserRepository;
import edu.plohoy.springbootdemo.api.domain.User;
import edu.plohoy.springbootdemo.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;

        User user = new User();
        user.setName("Vano");
        repository.save(user);
    }

    @GetMapping({"/user_list", "/users"})
    public List<User> allUsers() {
        return repository.findAll();
    }
}
