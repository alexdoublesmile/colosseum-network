package edu.plohoy.spitter.impl.controller;

import edu.plohoy.spitter.api.domain.Message;
import edu.plohoy.spitter.api.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController {

    @Resource(name = "message service")
    private MessageService service;

    @GetMapping("/message-list")
    public String getMessages(Map<String, Object> model) {
        List<Message> messages = service.findAll();

        model.put("messages", messages);
        return "message-list";
    }

    @PostMapping("/message-list")
    public String sendMessage(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {

        Message message = new Message(text, tag);
        service.save(message);

        List<Message> messages = service.findAll();
        model.put("messages", messages);
        return "message-list";
    }
}
