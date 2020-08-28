package edu.plohoy.springbootdemo.api.dao;

import edu.plohoy.springbootdemo.api.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
}
