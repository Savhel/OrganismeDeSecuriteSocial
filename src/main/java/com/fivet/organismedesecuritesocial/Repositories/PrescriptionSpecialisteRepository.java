package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.PrescriptionSpecialiste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrescriptionSpecialisteRepository extends JpaRepository<PrescriptionSpecialiste, UUID> {
}
