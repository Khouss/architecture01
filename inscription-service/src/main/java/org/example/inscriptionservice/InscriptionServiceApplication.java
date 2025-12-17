package org.example.inscriptionservice;

import org.example.inscriptionservice.DTO.Course;
import org.example.inscriptionservice.Feign.CourseClient;
import org.example.inscriptionservice.Repositorie.InscriptionRepository;
import org.example.inscriptionservice.entite.Inscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@SpringBootApplication
@EnableFeignClients
public class InscriptionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InscriptionServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            InscriptionRepository inscriptionRepository,
            CourseClient courseClient) {

        return args -> {

            List<Course> courses = courseClient.getAllCourses();

            courses.forEach(course -> {
                Inscription inscription = Inscription.builder()
                        .studentName("Student-" + course.getId())
                        .billingDate(new Date())
                        .courseId(course.getId())
                        .build();

                inscriptionRepository.save(inscription);
            });
        };
    }
}