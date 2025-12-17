package org.example.statistiqueservice.dto;

import lombok.Data;

@Data
public class CourseStatsDTO {
    private Long courseId;
    private String title;
    private String description;
    private String youtubeVideoId;
    private VideoStats videoStats;
}