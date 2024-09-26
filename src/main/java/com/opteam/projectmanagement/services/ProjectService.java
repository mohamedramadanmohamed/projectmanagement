package com.opteam.projectmanagement.services;

import com.opteam.projectmanagement.models.Project;
import com.opteam.projectmanagement.repositories.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException("Project not found"));
    }

    public Project findProjectById(Long id) {
        // Retrieve the project by its ID from the repository
        Optional<Project> project = projectRepository.findById(id);
        // Return the project if it exists, otherwise throw an exception
        return project.orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Long id, Project projectDetails) {
        Project project = getProjectById(id);
        project.setProjectName(projectDetails.getProjectName());
        // Set other fields...
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
