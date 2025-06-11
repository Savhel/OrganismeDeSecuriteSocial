package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AssureRepository extends JpaRepository<Assure, UUID> {
    Optional<Assure> findByIdPersonne(UUID idPersonne);
    void deleteAssuresByIdPersonne(UUID idPersonne);
    List<Assure> getAssuresByMedecintraitant(Medecin medecin);


    boolean existsByIdPersonne(UUID idPersonne);
}
