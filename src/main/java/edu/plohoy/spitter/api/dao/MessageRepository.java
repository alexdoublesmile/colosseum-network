package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
