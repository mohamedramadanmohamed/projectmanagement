package com.opteam.projectmanagement.model;

import com.opteam.projectmanagement.models.Project;
import com.opteam.projectmanagement.models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Arrays;

class ProjectModelTest {

    private Project project;
    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp() {
        project = new Project();
        project.setProjectName("New Project");
        project.setDescription("Description");
        project.setStartDate(new Date());
        project.setEndDate(new Date());
        project.setBudget(10000.0);
        project.setOwner("Manager1");
        project.setStatus("In Progress");

        task1 = new Task();
        task1.setTaskName("Task 1");
        task1.setAssignedTo("Employee1");
        task1.setProject(project); // Setting up relationship

        task2 = new Task();
        task2.setTaskName("Task 2");
        task2.setAssignedTo("Employee2");
        task2.setProject(project); // Setting up relationship

        project.setTasks(Arrays.asList(task1, task2));
    }

    @Test
    void testProjectCreation() {
        assertEquals("New Project", project.getProjectName());
        assertEquals(2, project.getTasks().size());
        assertEquals("Task 1", project.getTasks().get(0).getTaskName());
    }

    @Test
    void testTaskAssignment() {
        assertEquals("Employee1", task1.getAssignedTo());
        assertEquals(project, task1.getProject());
    }
}

