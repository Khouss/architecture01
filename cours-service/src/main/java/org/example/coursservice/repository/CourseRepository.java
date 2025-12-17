package org.example.coursservice.repository;

import org.example.coursservice.entite.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {}
