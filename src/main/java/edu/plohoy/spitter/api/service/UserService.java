package edu.plohoy.spitter.api.service;

import edu.plohoy.spitter.api.domain.User;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
}
