package org.example.coursservice.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
}
