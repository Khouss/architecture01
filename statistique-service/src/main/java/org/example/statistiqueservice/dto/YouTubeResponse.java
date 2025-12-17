package org.example.statistiqueservice.DTO;

import lombok.Data;

import java.util.List;

@Data
public class YouTubeResponse {
    private List<YouTubeItem> items;
}