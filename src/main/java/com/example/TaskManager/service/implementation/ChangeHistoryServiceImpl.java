package com.example.TaskManager.service.implementation;

import com.example.TaskManager.model.ChangeHistory;
import com.example.TaskManager.repository.ChangeHistoryRepository;
import com.example.TaskManager.service.ChangeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeHistoryServiceImpl implements ChangeHistoryService {

    private final ChangeHistoryRepository changeHistoryRepository;

    @Autowired
    public ChangeHistoryServiceImpl(ChangeHistoryRepository changeHistoryRepository) {
        this.changeHistoryRepository = changeHistoryRepository;
    }

    @Override
    public ChangeHistory save(ChangeHistory changeHistory) {
        return changeHistoryRepository.save(changeHistory);
    }

    @Override
    public List<ChangeHistory> findAll() {
        return changeHistoryRepository.findAll();
    }

    @Override
    public ChangeHistory findById(Long id) {
        return changeHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        changeHistoryRepository.deleteById(id);
    }

    @Override
    public List<ChangeHistory> findByTaskId(Long taskId) {
        // Пример метода для поиска истории изменений по задаче
        return changeHistoryRepository.findByTaskId(taskId);
    }
}
