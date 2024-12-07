package com.example.TaskManager.repository;

import com.example.TaskManager.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByUsername(String authority);
}