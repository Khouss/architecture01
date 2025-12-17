package org.example.inscriptionservice.Controller;

import lombok.RequiredArgsConstructor;
import org.example.inscriptionservice.Feign.CourseClient;
import org.example.inscriptionservice.Repositorie.InscriptionRepository;
import org.example.inscriptionservice.entite.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private CourseClient courseClient;

    @GetMapping
    public List<Inscription> getAllInscriptions() {
        List<Inscription> inscriptions = inscriptionRepository.findAll();

        inscriptions.forEach(inscription -> {
            inscription.setCourse(
                    courseClient.getCourseById(inscription.getCourseId())
            );
        });

        return inscriptions;
    }

    @GetMapping("/{id}")
    public Inscription getInscription(@PathVariable Long id) {

        Inscription inscription = inscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscription not found"));

        inscription.setCourse(
                courseClient.getCourseById(inscription.getCourseId())
        );

        return inscription;
    }
}