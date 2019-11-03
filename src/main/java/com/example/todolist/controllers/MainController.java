package com.example.todolist.controllers;

import com.example.todolist.models.Message;
import com.example.todolist.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final MessageRepository messageRepository;

    public MainController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping(path = "/")
    public List<Message> indexGet(){
        return (List<Message>)messageRepository.findAll();
    }

    @PostMapping(path = "/")
    public Message indexPot(@RequestBody Message message){


        return messageRepository.save(message);
    }

    @PutMapping(path = "/{id}")
    public Message indexPut(@PathVariable Long id, @RequestBody Message newMessage){
        return messageRepository
                .findById(id)
                .map(innerMessage -> messageRepository.save(
                        new Message(innerMessage.getId(),
                                    newMessage.getTitle(),
                                    newMessage.getText())
                )).orElseGet(() ->{
                    newMessage.setId(id);
                    return messageRepository.save(newMessage);
                });
    }


}

/*@PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
        .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
        })
        .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
        });
        }*/
