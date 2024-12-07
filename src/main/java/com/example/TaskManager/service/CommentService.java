package com.example.TaskManager.service;

import com.example.TaskManager.model.Comment;
import java.util.List;

public interface CommentService {
    Comment save(Comment comment);
    List<Comment> findAll();
    Comment findById(Long id);
    void deleteById(Long id);
    List<Comment> findByTaskId(Long taskId);
    // Дополнительные методы для работы с комментариями
}
