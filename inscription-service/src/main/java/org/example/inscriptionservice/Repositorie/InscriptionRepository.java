package org.example.inscriptionservice.Repositorie;


import org.example.inscriptionservice.entite.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
