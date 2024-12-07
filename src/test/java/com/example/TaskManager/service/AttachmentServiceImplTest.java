package com.example.TaskManager.service;

import com.example.TaskManager.TaskManagerApplication;
import com.example.TaskManager.model.Attachment;
import com.example.TaskManager.repository.AttachmentRepository;
import com.example.TaskManager.service.implementation.AttachmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = TaskManagerApplication.class)
@ActiveProfiles("test")
public class AttachmentServiceImplTest {

    @Mock
    private AttachmentRepository attachmentRepository;

    @InjectMocks
    private AttachmentServiceImpl attachmentService;

    private Attachment attachment;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        attachment = new Attachment();
        attachment.setId(1L);
        attachment.setFileName("testFile.txt");
        attachment.setFileType("text/plain");
        attachment.setData("test data".getBytes());
    }

    @Test
    public void testSaveAttachment() {
        when(attachmentRepository.save(any(Attachment.class))).thenReturn(attachment);

        Attachment savedAttachment = attachmentService.save(attachment);

        assertNotNull(savedAttachment);
        assertEquals("testFile.txt", savedAttachment.getFileName());
        verify(attachmentRepository, times(1)).save(attachment);
    }

    @Test
    public void testFindAllAttachments() {
        List<Attachment> attachments = Arrays.asList(attachment);
        when(attachmentRepository.findAll()).thenReturn(attachments);

        List<Attachment> result = attachmentService.findAll();

        assertEquals(1, result.size());
        assertEquals("testFile.txt", result.get(0).getFileName());
        verify(attachmentRepository, times(1)).findAll();
    }

    @Test
    public void testFindAttachmentById() {
        when(attachmentRepository.findById(1L)).thenReturn(Optional.of(attachment));

        Attachment result = attachmentService.findById(1L);

        assertNotNull(result);
        assertEquals("testFile.txt", result.getFileName());
        verify(attachmentRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteAttachmentById() {
        doNothing().when(attachmentRepository).deleteById(1L);
        attachmentService.deleteById(1L);
        verify(attachmentRepository, times(1)).deleteById(1L);
    }
}
