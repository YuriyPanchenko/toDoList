package com.example.todolist.repository;

import com.example.todolist.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    void deleteById(Long id);
}
