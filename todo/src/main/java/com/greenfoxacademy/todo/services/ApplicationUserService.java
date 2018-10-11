package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.models.ApplicationUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface ApplicationUserService {
    void save(ApplicationUser applicationUser);

    Iterable<ApplicationUser> findAll();

    ApplicationUser findById(long id);

    void updateAssignee(ApplicationUser applicationUser);

    void deleteAssignee(ApplicationUser applicationUser);
}
