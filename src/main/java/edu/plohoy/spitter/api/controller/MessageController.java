package edu.plohoy.spitter.api.controller;

import edu.plohoy.spitter.api.domain.Message;
import edu.plohoy.spitter.api.domain.User;
import edu.plohoy.spitter.api.service.MessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/main")
    public String viewAll(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = service.findByTag(filter);
        } else {
            messages = service.findAll();
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model) {

        Message message = new Message(text, tag, user);
        service.save(message);

        List<Message> messages = service.findAll();
        model.put("messages", messages);
        return "main";
    }
}
