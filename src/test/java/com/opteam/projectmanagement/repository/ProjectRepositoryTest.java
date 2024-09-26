package com.opteam.projectmanagement.repository;

import com.opteam.projectmanagement.models.Project;
import com.opteam.projectmanagement.models.Task;
import com.opteam.projectmanagement.repositories.ProjectRepository;
import com.opteam.projectmanagement.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@DataJpaTest
class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveProject() {
        Project project = new Project();
        project.setProjectName("Test Project");
        project.setDescription("Test Description");
        Project savedProject = projectRepository.save(project);

        assertNotNull(savedProject.getProjectId());
        assertEquals("Test Project", savedProject.getProjectName());
    }

    @Test
    void testFindAllProjects() {
        Project project1 = new Project();
        project1.setProjectName("Project 1");
        projectRepository.save(project1);

        Project project2 = new Project();
        project2.setProjectName("Project 2");
        projectRepository.save(project2);

        List<Project> projects = projectRepository.findAll();
        assertEquals(2, projects.size());
    }
}

