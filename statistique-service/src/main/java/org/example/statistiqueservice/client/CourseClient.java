package org.example.statistiqueservice.client;

import lombok.RequiredArgsConstructor;
import org.example.statistiqueservice.dto.CourseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseClient {

    private final WebClient.Builder loadBalancedWebClientBuilder;

    public Mono<List<CourseDTO>> getCourses() {
        return loadBalancedWebClientBuilder.build()
                .get()
                .uri("lb://COURS-SERVICE/courses")
                .retrieve()
                .bodyToFlux(CourseDTO.class)
                .collectList();
    }
}
