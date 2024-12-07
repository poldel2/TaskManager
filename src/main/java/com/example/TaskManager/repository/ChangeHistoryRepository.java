package com.example.TaskManager.repository;

import com.example.TaskManager.model.ChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChangeHistoryRepository extends JpaRepository<ChangeHistory, Long> {
    List<ChangeHistory> findByTaskId(Long taskId);
}