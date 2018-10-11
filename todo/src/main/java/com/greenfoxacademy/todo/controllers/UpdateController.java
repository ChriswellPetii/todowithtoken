package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.ApplicationUser;
import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.ApplicationUserService;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UpdateController {
    private TodoService todoService;
    private ApplicationUserService applicationUserService;

    public UpdateController(TodoService todoService, ApplicationUserService applicationUserService) {
        this.todoService = todoService;
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/{id}/update")
    public String getUpdate(@PathVariable Long id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("name", todo.getName());
        model.addAttribute("isDone", todo.isDone());
        model.addAttribute("isUrgent", todo.isUrgent());
        model.addAttribute("todo", todo);
        return "todoupdate";
    }

    @PostMapping("/{id}/update")
    public String postUpdate(@PathVariable Long id, Todo todo) {
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/{id}/updateuser")
    public String getUpdateUser(@PathVariable Long id, Model model) {
        ApplicationUser applicationUser = applicationUserService.findById(id);
        model.addAttribute("name", applicationUser.getUsername());
        model.addAttribute("email", applicationUser.getPassword());
        model.addAttribute("user", applicationUser);
        return "assigneesupdate";
    }

    @PostMapping("/{id}/updateuser")
    public String postUpdateUser(@PathVariable Long id, ApplicationUser applicationUser) {
        applicationUserService.save(applicationUser);
        return "redirect:/assigneeslist";
    }


    @GetMapping("/{id}/updatedone")
    public String updateDone(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        todo.setDone(!todo.isDone());
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/{id}/updateurgent")
    public String updateUrgent(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        todo.setUrgent(!todo.isUrgent());
        todoService.save(todo);
        return "redirect:/";
    }

    @GetMapping("/{id}/updatedoneactive")
    public String updateDoneActive(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        todo.setDone(!todo.isDone());
        todoService.save(todo);
        return "redirect:/todo?isActive=" + !todo.isDone();
    }

    @GetMapping("/{id}/updateurgentactive")
    public String updateUrgentActive(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        todo.setUrgent(!todo.isUrgent());
        todoService.save(todo);
        return "redirect:/todo?isActive=" + !todo.isDone();
    }


}
