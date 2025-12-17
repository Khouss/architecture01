package org.example.coursservice.repository;


import org.example.coursservice.entite.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
}
