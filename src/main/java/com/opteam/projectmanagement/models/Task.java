package com.opteam.projectmanagement.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private String taskName;
    private String description;
    private String assignedTo;
    private Date startDate;
    private Date endDate;
    private String priority;
    private String status;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
