package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
