package com.greenfoxacademy.todo.services;

import com.greenfoxacademy.todo.interfaces.ApplicationUserRepository;
import com.greenfoxacademy.todo.models.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import static java.util.Collections.emptyList;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {
    private ApplicationUserRepository applicationUserRepository;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void save(ApplicationUser todo) {
        applicationUserRepository.save(todo);
    }

    @Override
    public Iterable<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }

    @Override
    public ApplicationUser findById(long id) {
        return applicationUserRepository.findById(id).get();
    }

    @Override
    public void updateAssignee(ApplicationUser todo) {
        applicationUserRepository.save(todo);
    }

    @Override
    public void deleteAssignee(ApplicationUser applicationUser) {
        applicationUserRepository.delete(applicationUser);
    }

}