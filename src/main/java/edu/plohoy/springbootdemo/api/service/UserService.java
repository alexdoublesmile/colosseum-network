package edu.plohoy.springbootdemo.api.service;

import edu.plohoy.springbootdemo.api.dao.UserRepository;
import edu.plohoy.springbootdemo.api.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
