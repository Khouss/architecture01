package org.example.coursservice.Controller;

import org.example.coursservice.entite.Course;
import org.example.coursservice.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // Créer un cours
    @PostMapping
    public Course create(@RequestBody Course c) {
        return service.save(c);
    }

    // Récupérer tous les cours
    @GetMapping
    public List<Course> all() {
        return service.findAll();
    }

    // Récupérer un cours par ID
    @GetMapping("/{id}")
    public Course getById(@PathVariable Long id) {
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
    }

    // Mettre à jour un cours
    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course updatedCourse) {
        Course course = service.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
        course.setTitle(updatedCourse.getTitle());
        course.setDescription(updatedCourse.getDescription());
        course.setYoutubeVideoId(updatedCourse.getYoutubeVideoId());
        // Le service gérera la récupération du teacher
        course.setTeacher(updatedCourse.getTeacher());
        return service.save(course);
    }

    // Supprimer un cours
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
        service.deleteById(id);
    }
}
