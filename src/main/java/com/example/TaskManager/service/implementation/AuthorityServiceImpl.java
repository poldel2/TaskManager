package com.example.TaskManager.service;

import com.example.TaskManager.model.Authority;
import com.example.TaskManager.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void save(Authority authority) {
        authorityRepository.save(authority);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public Authority findByUsername(String username) {
        return authorityRepository.findByUsername(username);
    }

    @Override
    public void delete(Authority authority) {
        authorityRepository.delete(authority);
    }
}
