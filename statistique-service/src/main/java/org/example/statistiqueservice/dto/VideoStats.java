package org.example.statistiqueservice.dto;

import lombok.Data;

@Data
public class VideoStats {
    private String videoId;
    private long viewCount;
    private long likeCount;
    private long commentCount;
}
