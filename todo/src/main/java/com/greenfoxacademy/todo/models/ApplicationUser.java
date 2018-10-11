package com.greenfoxacademy.todo.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    private String username;

//    @OneToMany(mappedBy = "assignee")
//    private List<Todo> todos;

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ApplicationUser() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
