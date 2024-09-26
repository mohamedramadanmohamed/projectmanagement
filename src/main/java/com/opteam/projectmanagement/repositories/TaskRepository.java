package com.opteam.projectmanagement.repositories;

import com.opteam.projectmanagement.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatusAndEndDateBefore(String status, Date endDate);
}

