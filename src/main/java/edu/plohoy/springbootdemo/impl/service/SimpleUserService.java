package edu.plohoy.springbootdemo.impl.service;

import edu.plohoy.springbootdemo.api.dao.UserRepository;
import edu.plohoy.springbootdemo.api.domain.User;
import edu.plohoy.springbootdemo.api.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

public class SimpleUserService implements UserService {
    private UserRepository dao;

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
