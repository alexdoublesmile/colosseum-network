package edu.plohoy.spitter.api.service;

import edu.plohoy.spitter.api.domain.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();
    List<Message> findByTag(String tag);
    void save(Message message);
}
