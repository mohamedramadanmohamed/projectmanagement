package com.opteam.projectmanagement.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "app_user") // or another name
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        MANAGER, EMPLOYEE
    }
}
