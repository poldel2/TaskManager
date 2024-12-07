package com.example.TaskManager.service;

import com.example.TaskManager.model.Project;
import com.example.TaskManager.repository.ProjectRepository;
import com.example.TaskManager.service.implementation.ProjectServiceImpl;
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

@SpringBootTest
@ActiveProfiles("test")
public class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private Project project;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        project = new Project();
        project.setId(1L);
        project.setName("Test Project");
        project.setDescription("Test Description");
    }

    @Test
    public void testSaveProject() {
        when(projectRepository.save(any(Project.class))).thenReturn(project);

        Project savedProject = projectService.save(project);

        assertNotNull(savedProject);
        assertEquals("Test Project", savedProject.getName());
        verify(projectRepository, times(1)).save(project);
    }

    @Test
    public void testFindAllProjects() {
        List<Project> projects = Arrays.asList(project);
        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> result = projectService.findAll();

        assertEquals(1, result.size());
        assertEquals("Test Project", result.get(0).getName());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    public void testFindProjectById() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));

        Project result = projectService.findById(1L);

        assertNotNull(result);
        assertEquals("Test Project", result.getName());
        verify(projectRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeleteProjectById() {
        doNothing().when(projectRepository).deleteById(1L);
        projectService.deleteById(1L);
        verify(projectRepository, times(1)).deleteById(1L);
    }
}
