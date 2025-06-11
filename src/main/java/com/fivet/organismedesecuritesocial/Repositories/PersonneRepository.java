package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Personne;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PersonneRepository extends JpaRepository<Personne,String> {
    Optional<Personne> findByMail(String mail);
    Optional<Personne> findByIdPersonne(UUID idPersonne);

    Optional<Personne> deletePersonneByIdPersonne(UUID idPersonne);
}
