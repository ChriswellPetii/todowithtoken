package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public void addTodo(@RequestBody Todo todo) {
        todoService.save(todo);
    }

    @GetMapping
    public List<Todo> getTodos() {
        return (List<Todo>) todoService.findAll();
    }

    @PutMapping("/{id}")
    public void editTodo(@PathVariable long id, @RequestBody Todo todo) {
        Todo existingTodo = todoService.findById(id);
        Assert.notNull(existingTodo, "Todo not found");
        existingTodo.setName(todo.getName());
        todoService.save(existingTodo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable long id) {
        Todo todoToDel = todoService.findById(id);
        todoService.delete(todoToDel);
    }
}
