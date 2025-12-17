package org.example.coursservice.service;

import org.example.coursservice.entite.Course;
import org.example.coursservice.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    // Créer ou mettre à jour un cours
    public Course save(Course c) {
        return repo.save(c);
    }

    // Récupérer tous les cours
    public List<Course> findAll() {
        return repo.findAll();
    }

    // Récupérer un cours par ID
    public Optional<Course> findById(Long id) {
        return repo.findById(id);
    }

    // Supprimer un cours par ID
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public static class AuthenticationFailedException extends Throwable {
        public AuthenticationFailedException(String s) {
        }
    }
}