package org.example.statistiqueservice.DTO;


import lombok.Data;

@Data
public class YouTubeStatsDTO {
    private String videoId;
    private String viewCount;
    private String likeCount;
    private String commentCount;
}