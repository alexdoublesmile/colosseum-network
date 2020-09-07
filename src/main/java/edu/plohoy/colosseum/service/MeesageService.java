package edu.plohoy.colosseum.service;

import edu.plohoy.colosseum.domain.Message;
import edu.plohoy.colosseum.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MeesageService {

    @Autowired
    private MessageRepo dao;

    Page<Message> findByTag(String tag, Pageable pageable) {
        return dao.findByTag(tag, pageable);
    }

    Page<Message> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
