package org.example.coursservice;

import org.example.coursservice.entite.Course;
import org.example.coursservice.entite.Teacher;
import org.example.coursservice.repository.CourseRepository;
import org.example.coursservice.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootApplication
public class CoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        // Verify that the application context is not null
        assertNotNull(context, "The application context should have loaded successfully");
    }

    @Bean
    CommandLineRunner initData(
            CourseRepository courseRepository,
            TeacherRepository teacherRepository
    ) {
        return args -> {

            Teacher teacher = new Teacher();
            teacher.setName("Dr Spring");
            teacher.setEmail("spring@edu.com");
            teacherRepository.save(teacher);

            Course c1 = new Course();
            c1.setTitle("\uD83D\uDE80 \uD83D\uDD25 Mastering Microservices: Spring boot, Spring Cloud and Keycloak In 7 Hours");
            c1.setDescription("Architecture distribuée");
            c1.setYoutubeVideoId("jdeSV0GRvwI");
            c1.setTeacher(teacher);

            Course c2 = new Course();
            c2.setTitle("Event Driven Architecture- Spring Cloud Streams - KAFKA - KAFKA Streams");
            c2.setDescription("Event Driven Architecture- Spring Cloud Streams - KAFKA - KAFKA Streams");
            c2.setYoutubeVideoId("8uY7JE_X_Fw");
            c2.setTeacher(teacher);


            Course c3 = new Course();
            c3.setTitle("React JS");
            c3.setDescription("React JS");
            c3.setYoutubeVideoId("SqcY0GlETPk");
            c3.setTeacher(teacher);

            courseRepository.saveAll(List.of(c1, c2,c3));
        };
    }
}