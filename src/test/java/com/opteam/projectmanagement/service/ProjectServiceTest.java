package com.opteam.projectmanagement.service;

import com.opteam.projectmanagement.models.Project;
import com.opteam.projectmanagement.models.Task;
import com.opteam.projectmanagement.repositories.ProjectRepository;
import com.opteam.projectmanagement.repositories.TaskRepository;
import com.opteam.projectmanagement.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private TaskRepository taskRepository;

    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        project = new Project();
        project.setProjectId(1L);
        project.setProjectName("Test Project");
    }

    @Test
    void testFindProjectById() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project));
        Project foundProject = projectService.findProjectById(1L);
        assertNotNull(foundProject);
        assertEquals("Test Project", foundProject.getProjectName());
    }

    @Test
    void testCreateNewProject() {
        when(projectRepository.save(project)).thenReturn(project);
        Project newProject = projectService.createProject(project);
        assertEquals("Test Project", newProject.getProjectName());
    }
}

