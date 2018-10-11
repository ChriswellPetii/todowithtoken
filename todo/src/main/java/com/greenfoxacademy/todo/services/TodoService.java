package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    void save(Todo post);

    Iterable<Todo> findAll();

    Todo findById(long id);

    void updateTodo(Todo todo);

    void deleteTodo(long id);

    Todo findByName(String name);

    Iterable<Todo> findAllByName(String name);

    void delete(Todo todo);
}
