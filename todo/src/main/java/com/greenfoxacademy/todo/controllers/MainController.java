package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.services.ApplicationUserService;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ComponentScan
public class MainController {
    private TodoService todoService;
    private ApplicationUserService applicationUserService;

    public MainController(TodoService todoService, ApplicationUserService applicationUserService) {
        this.todoService = todoService;
        this.applicationUserService = applicationUserService;
    }

    @RequestMapping("/todo")
    public String getListActive(@RequestParam(value = "isActive", required = false) Boolean isActive, Model model) {
        model.addAttribute("parameter", isActive);
        model.addAttribute("todos", todoService.findAll());
        return "todolistactive";
    }

    @RequestMapping("/")
    public String getList(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "todolist";
    }

    @RequestMapping("/assignees")
    public String getAssignees(Model model) {
        model.addAttribute("users", applicationUserService.findAll());
        return "assigneeslist";
    }
}
