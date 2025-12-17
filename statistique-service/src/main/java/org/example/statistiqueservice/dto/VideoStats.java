package org.example.statistiqueservice.DTO;

import lombok.Data;

@Data
public class VideoStats {
    private String videoId;
    private long viewCount;
    private long likeCount;
    private long commentCount;
}
