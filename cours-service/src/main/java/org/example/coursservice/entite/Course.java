package org.example.coursservice.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String youtubeVideoId;

    @ManyToOne
    private Teacher teacher;
}
