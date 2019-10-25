package com.example.todolist.controllers;

import com.example.todolist.models.Message;
import com.example.todolist.repository.MessageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private final MessageRepository messageRepository;

    public MainController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping(path = "/")
    public List<Message> index(){
        return (List<Message>)messageRepository.findAll();
    }
}
