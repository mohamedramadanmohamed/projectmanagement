package com.opteam.projectmanagement.controller;

import com.opteam.projectmanagement.controllers.ProjectController;
import com.opteam.projectmanagement.models.Project;
import com.opteam.projectmanagement.services.ProjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    @Test
    void testGetProjectById() throws Exception {
        Project project = new Project();
        project.setProjectId(1L);
        project.setProjectName("Test Project");

        when(projectService.findProjectById(1L)).thenReturn(project);

        mockMvc.perform(get("/api/projects/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectName").value("Test Project"));
    }
}

