package org.example.inscriptionservice.entite;

import jakarta.persistence.*;
import lombok.*;
import org.example.inscriptionservice.dto.Course;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    private Date billingDate;

    private Long courseId;

    @Transient
    private Course course;
}