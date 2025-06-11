package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ConsultationRepository  extends JpaRepository<Consultation, UUID> {
    Optional<Consultation> findById(UUID idConsultation);

    List<Consultation> findByAssure_IdPersonne(UUID idAssure);
    List<Consultation> findByMedecin_IdPersonne(UUID idMedecin);

}
