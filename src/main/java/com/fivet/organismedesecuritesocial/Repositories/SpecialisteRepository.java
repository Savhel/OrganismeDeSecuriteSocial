package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Specialiste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpecialisteRepository extends JpaRepository<Specialiste, UUID> {
    Optional<Specialiste> findByIdPersonne(UUID idPersonne);
    Optional<Specialiste> deleteSpecialisteByIdPersonne(UUID idPersonne);
}
