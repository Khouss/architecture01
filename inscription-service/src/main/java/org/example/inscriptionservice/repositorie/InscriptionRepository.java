package org.example.inscriptionservice.repositorie;


import org.example.inscriptionservice.entite.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
