package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MedecinRepository extends JpaRepository<Medecin,UUID> {
    Optional<Medecin> findByIdPersonne(UUID idPersonne);
    Optional<Medecin> deleteMedecinByIdPersonne(UUID idPersonne);

    boolean existsByIdPersonne(UUID idPersonne);
}
