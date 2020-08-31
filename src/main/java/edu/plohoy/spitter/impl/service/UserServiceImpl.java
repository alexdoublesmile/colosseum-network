package edu.plohoy.spitter.impl.service;

import edu.plohoy.spitter.api.dao.UserRepository;
import edu.plohoy.spitter.api.domain.User;
import edu.plohoy.spitter.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("user service")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository dao;

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }
}
