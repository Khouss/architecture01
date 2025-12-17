package org.example.coursservice.service;

import org.example.coursservice.dto.AuthResponse;
import org.example.coursservice.dto.LoginRequest;
import org.example.coursservice.dto.RegisterRequest;
import org.example.coursservice.entite.Teacher;
import org.example.coursservice.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {

    @ResponseStatus(HttpStatus.CONFLICT) // HTTP 409
    public class TeacherAlreadyExistsException extends RuntimeException {

        public TeacherAlreadyExistsException(String message) {
            super(message);
        }
    }
    public class AuthenticationFailedException extends RuntimeException {

        public AuthenticationFailedException(String message) {
            super(message);
        }
    }

    private final TeacherRepository teacherRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public AuthResponse register(RegisterRequest request) {
        // Vérifier si l'email existe déjà
        Optional<Teacher> existingTeacher = teacherRepository.findByEmail(request.getEmail());
        if (existingTeacher.isPresent()) {
            throw new TeacherAlreadyExistsException("Un enseignant avec cet email existe déjà");
        }

        // Créer un nouvel enseignant
        Teacher teacher = new Teacher();
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setPassword(passwordEncoder.encode(request.getPassword()));

        Teacher savedTeacher = teacherRepository.save(teacher);

        // Générer un token simple (dans un vrai projet, utiliser JWT)
        String token = generateToken(savedTeacher);

        return new AuthResponse(token, savedTeacher, "Inscription réussie");
    }

    public AuthResponse login(LoginRequest request) {
        // Trouver l'enseignant par email
        Optional<Teacher> teacherOpt = teacherRepository.findByEmail(request.getEmail());
        Teacher teacher = null;
        if (!passwordEncoder.matches(request.getPassword(), teacher.getPassword())) {
            throw new AuthenticationFailedException("Email ou mot de passe incorrect");
        }


        teacher = teacherOpt.get();

        // Vérifier le mot de passe
        if (!passwordEncoder.matches(request.getPassword(), teacher.getPassword())) {
            throw new RuntimeException("Email ou mot de passe incorrect");
        }

        // Générer un token
        String token = generateToken(teacher);

        // Ne pas renvoyer le mot de passe
        teacher.setPassword(null);

        return new AuthResponse(token, teacher, "Connexion réussie");
    }

    private String generateToken(Teacher teacher) {
        // Génération d'un token simple (UUID)
        // Dans un vrai projet, utiliser JWT avec Spring Security
        return UUID.randomUUID().toString() + "_" + teacher.getId();
    }

    public Optional<Teacher> findByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }
}

