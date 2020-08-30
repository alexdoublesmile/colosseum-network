package edu.plohoy.spitter.impl.controller;

import edu.plohoy.spitter.api.dao.MessageRepository;
import edu.plohoy.spitter.api.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.Map;

@Controller
public class MessageController {

    private MessageRepository dao;

    @Autowired
    public void setDao(MessageRepository dao) {
        this.dao = dao;
    }

    @GetMapping("/message-list")
    public String getMessages(Map<String, Object> model) {
        Iterable<Message> messages = dao.findAll();

        model.put("messages", messages);
        return "message-list";
    }

    @PostMapping("/message-list")
    public String sendMessage(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {

        Message message = new Message(text, tag);
        dao.save(message);

        Iterable<Message> messages = dao.findAll();
        model.put("messages", messages);
        return "message-list";
    }
}
