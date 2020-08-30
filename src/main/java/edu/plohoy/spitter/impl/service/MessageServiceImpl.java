package edu.plohoy.spitter.impl.service;

import edu.plohoy.spitter.api.dao.MessageRepository;
import edu.plohoy.spitter.api.domain.Message;
import edu.plohoy.spitter.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("message service")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository dao;

    @Override
    public List<Message> findAll() {
        List<Message> messageList = (List<Message>) dao.findAll();
        return messageList;
    }

    @Override
    public List<Message> findByTag(String tag) {
        return dao.findByTag(tag);
    }

    @Override
    public void save(Message message) {
        dao.save(message);
    }
}
