package org.example.statistiqueservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.statistiqueservice.dto.*;
import org.example.statistiqueservice.client.CourseClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatistiqueService {

    private final CourseClient courseClient;
    private final WebClient youtubeWebClient;
    private final ObjectMapper objectMapper;

    @Value("${youtube.api.key}")
    private String youtubeApiKey;

    public Mono<List<YouTubeStatsDTO>> getAllCoursesStats() {

        return courseClient.getCourses()
                .flatMapMany(Flux::fromIterable)
                .filter(course -> course.getYoutubeVideoId() != null)
                .flatMap(course -> getVideoStats(course.getYoutubeVideoId()))
                .collectList();
    }

    private Mono<YouTubeStatsDTO> getVideoStats(String videoId) {

        return youtubeWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/youtube/v3/videos")
                        .queryParam("part", "statistics")
                        .queryParam("id", videoId)
                        .queryParam("key", youtubeApiKey)
                        .build())
                .retrieve()
                .bodyToMono(String.class)   // ✅ STRING
                .map(response -> {
                    try {
                        JsonNode json = objectMapper.readTree(response);
                        JsonNode stats = json.path("items").path(0).path("statistics");

                        YouTubeStatsDTO dto = new YouTubeStatsDTO();
                        dto.setVideoId(videoId);
                        dto.setViewCount(stats.path("viewCount").asText("0"));
                        dto.setLikeCount(stats.path("likeCount").asText("0"));
                        dto.setCommentCount(stats.path("commentCount").asText("0"));

                        return dto;

                    } catch (Exception e) {
                        throw new RuntimeException("Erreur parsing JSON YouTube", e);
                    }
                });
    }

    }




