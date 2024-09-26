package com.opteam.projectmanagement.repositories;

import com.opteam.projectmanagement.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
