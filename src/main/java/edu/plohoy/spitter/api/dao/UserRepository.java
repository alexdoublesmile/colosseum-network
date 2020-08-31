package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUserName(String name);
}
