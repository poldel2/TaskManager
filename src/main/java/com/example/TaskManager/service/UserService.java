package com.example.TaskManager.service;

import com.example.TaskManager.model.User;

public interface UserService {
    public User findByUsername(String username);
    public void registerUser(User user);
}
