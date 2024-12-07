package com.example.TaskManager.service.implementation;

import com.example.TaskManager.model.Attachment;
import com.example.TaskManager.repository.AttachmentRepository;
import com.example.TaskManager.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    @Autowired
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment save(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public List<Attachment> findAll() {
        return attachmentRepository.findAll();
    }

    @Override
    public Attachment findById(Long id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        attachmentRepository.deleteById(id);
    }

    @Override
    public List<Attachment> findByTaskId(Long taskId) {
        // Пример метода для поиска вложений по задаче
        return attachmentRepository.findByTaskId(taskId);
    }
}
