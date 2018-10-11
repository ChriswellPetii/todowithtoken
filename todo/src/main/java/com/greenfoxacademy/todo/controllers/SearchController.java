package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    private TodoService todoService;

    public SearchController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/search")
    public String searchPost(String name) {
        Todo todo = todoService.findByName(name);
        if (todo == null || name == null){
            return "redirect:/";
        }
        return "redirect:/search?name=" + todo.getName();
    }

    @GetMapping("/search")
    public String searchGet(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",todoService.findByName(name));
        model.addAttribute("todos", todoService.findAllByName(name));
        return "todolist";
    }
}
