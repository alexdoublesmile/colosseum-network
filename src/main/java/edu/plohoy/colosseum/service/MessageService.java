package edu.plohoy.colosseum.service;

import edu.plohoy.colosseum.domain.Message;
import edu.plohoy.colosseum.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepo dao;

    Page<Message> getMessageList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return dao.findByTag(filter, pageable);

        } else {
            return dao.findAll(pageable);
        }
    }

    Page<Message> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
