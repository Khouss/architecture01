package org.example.apigateway.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();

        // 1. Specify the origins (your frontend URLs) that are allowed.
        //    Using addAllowedOriginPattern instead of addAllowedOrigin to avoid conflicts
        corsConfig.addAllowedOriginPattern("*");

        // 2. Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
        corsConfig.addAllowedMethod("*");

        // 3. Allow all headers
        corsConfig.addAllowedHeader("*");

        // 4. Important for cookies/session headers if you use them
        corsConfig.setAllowCredentials(true);

        // 5. Allow exposed headers
        corsConfig.addExposedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply this CORS configuration to all paths
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
