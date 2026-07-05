package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1, "nguyenvana", "vana@example.com", "ADMIN"));
        users.add(new User(2, "tranthingoc", "ngoc@example.com", "USER"));
        users.add(new User(3, "lehoang", "hoang@example.com", "USER"));
    }

    public List<User> findAll() {
        return users;
    }
}
