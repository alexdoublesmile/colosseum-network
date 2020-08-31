package edu.plohoy.spitter.api.service;

import edu.plohoy.spitter.api.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    void save(User user);
}
