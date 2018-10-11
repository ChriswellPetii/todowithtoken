package com.greenfoxacademy.todo.interfaces;

import com.greenfoxacademy.todo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findByName(String name);

    Iterable<Todo> findAllByName(String name);
}
