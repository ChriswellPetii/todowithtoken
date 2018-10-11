package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.ApplicationUser;
import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.services.ApplicationUserService;
import com.greenfoxacademy.todo.services.TodoService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan
public class DeleteController {
    private TodoService todoService;
    private ApplicationUserService applicationUserService;

    public DeleteController(TodoService todoService, ApplicationUserService applicationUserService) {
        this.todoService = todoService;
        this.applicationUserService = applicationUserService;
    }


    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        Todo todo = todoService.findById(id);
        todoService.delete(todo);
        return "redirect:/";
    }

    @RequestMapping("/{id}/deleteuser")
    public String deleteUser(@PathVariable Long id) {
        ApplicationUser applicationUser = applicationUserService.findById(id);
        applicationUserService.deleteAssignee(applicationUser);
        return "redirect:/assigneeslist";
    }

}
