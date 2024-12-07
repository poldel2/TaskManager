package com.example.TaskManager.service;

import com.example.TaskManager.model.Authority;

import java.util.List;

public interface AuthorityService {
    void save(Authority authority);
    List<Authority> findAll();
    Authority findByUsername(String username);
    void delete(Authority authority);
}
