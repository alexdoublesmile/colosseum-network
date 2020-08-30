package edu.plohoy.spitter.api.dao;

import edu.plohoy.spitter.api.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
