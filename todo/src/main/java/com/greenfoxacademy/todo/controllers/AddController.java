package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@ComponentScan
public class AddController {
    private TodoService todoService;

    public AddController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/add")
    public String getToDo() {
        return "todoadd";
    }

    @PostMapping("/add")
    public String postToDo(String name) {
        Todo todo = new Todo(name);
        todoService.save(todo);
        return "redirect:/";
    }


}
