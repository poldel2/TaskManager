package com.example.TaskManager.service;

import com.example.TaskManager.model.Task;
import java.util.List;

public interface TaskService {
    Task save(Task task);
    List<Task> findAll();
    Task findById(Long id);
    void deleteById(Long id);
    List<Task> findByProjectId(Long projectId);
    // Дополнительные методы для работы с задачами
}
