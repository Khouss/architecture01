package org.example.statistiqueservice.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    // POUR EUREKA (COURS-SERVICE)
    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    // POUR API EXTERNE (YOUTUBE)
    @Bean
    public WebClient youtubeWebClient() {
        return WebClient.builder()
                .baseUrl("https://www.googleapis.com")
                .build();
    }
}
