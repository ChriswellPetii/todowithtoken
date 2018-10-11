package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.interfaces.TodoRepository;
import com.greenfoxacademy.todo.models.Todo;
import org.springframework.stereotype.Service;


@Service
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findByName(String name) {
        return todoRepository.findByName(name);
    }

    @Override
    public Iterable<Todo> findAllByName(String name) {
        return todoRepository.findAllByName(name);
    }

    @Override
    public void delete(Todo todo) {
        todoRepository.deleteById(todo.getId());
    }

}
