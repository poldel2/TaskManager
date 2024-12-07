package com.example.TaskManager.service;

import com.example.TaskManager.model.Project;
import java.util.List;

public interface ProjectService {
    Project save(Project project);
    List<Project> findAll();
    Project findById(Long id);
    void deleteById(Long id);
    // Дополнительные методы для работы с проектами
}
