package org.example.statistiqueservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.statistiqueservice.dto.YouTubeStatsDTO;
import org.example.statistiqueservice.service.StatistiqueService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class StatistiqueController {

    private final StatistiqueService statistiqueService;

    @GetMapping
    public Mono<List<YouTubeStatsDTO>> getStats() {
        return statistiqueService.getAllCoursesStats();
    }
}
