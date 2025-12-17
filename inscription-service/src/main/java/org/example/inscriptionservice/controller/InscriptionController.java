package org.example.inscriptionservice.controller;

import org.example.inscriptionservice.feign.CourseClient;
import org.example.inscriptionservice.repositorie.InscriptionRepository;
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