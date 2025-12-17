package org.example.inscriptionservice.feign;

import org.example.inscriptionservice.dto.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cours-service", url = "http://localhost:8081")
public interface CourseClient {
    @GetMapping("/courses/{id}")
    Course getCourseById(@PathVariable Long id);

    @GetMapping("/courses")
    List<Course> getAllCourses();
}