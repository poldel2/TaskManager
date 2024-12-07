package com.example.TaskManager.service;

import com.example.TaskManager.model.Attachment;
import java.util.List;

public interface AttachmentService {
    Attachment save(Attachment attachment);
    List<Attachment> findAll();
    Attachment findById(Long id);
    void deleteById(Long id);
    List<Attachment> findByTaskId(Long taskId);
    // Дополнительные методы для работы с вложениями
}
