package org.example.statistiqueservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootApplication
public class StatistiqueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatistiqueServiceApplication.class, args);
    }
    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {
        // Vérifie que le contexte Spring Boot s'est bien chargé
        assertNotNull(context, "The application context should have loaded successfully");
    }

}
