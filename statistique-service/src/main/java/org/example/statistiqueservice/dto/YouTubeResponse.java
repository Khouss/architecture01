package org.example.statistiqueservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class YouTubeResponse {
    private List<YouTubeItem> items;
}