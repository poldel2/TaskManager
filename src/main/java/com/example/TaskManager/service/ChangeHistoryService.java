package com.example.TaskManager.service;

import com.example.TaskManager.model.ChangeHistory;
import java.util.List;

public interface ChangeHistoryService {
    ChangeHistory save(ChangeHistory changeHistory);
    List<ChangeHistory> findAll();
    ChangeHistory findById(Long id);
    void deleteById(Long id);
    List<ChangeHistory> findByTaskId(Long taskId);
    // Дополнительные методы для работы с историей изменений
}
