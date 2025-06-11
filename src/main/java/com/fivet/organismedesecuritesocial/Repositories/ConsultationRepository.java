package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ConsultationRepository  extends JpaRepository<Consultation, UUID> {
    Optional<Consultation> findById(UUID idConsultation);
}
