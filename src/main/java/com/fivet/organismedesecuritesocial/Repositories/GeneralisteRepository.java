package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GeneralisteRepository extends JpaRepository<Generaliste, UUID> {
    Optional<Generaliste> findByIdPersonne(UUID idPersonne);
    Optional<Generaliste> deleteMedecinByIdPersonne(UUID idPersonne);
}
