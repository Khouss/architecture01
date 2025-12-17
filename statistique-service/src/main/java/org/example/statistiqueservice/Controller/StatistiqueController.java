package org.example.statistiqueservice.Controller;

import lombok.RequiredArgsConstructor;
import org.example.statistiqueservice.DTO.CourseStatsDTO;
import org.example.statistiqueservice.DTO.VideoStats;
import org.example.statistiqueservice.DTO.YouTubeStatsDTO;
import org.example.statistiqueservice.Service.StatistiqueService;
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
