package org.example.inscriptionservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Course {
    private Long id;
    private String title;
    private String description;
    private String youtubeVideoId;

}