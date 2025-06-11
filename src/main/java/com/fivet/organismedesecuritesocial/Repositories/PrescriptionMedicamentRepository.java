package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.PrescriptionMedicament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PrescriptionMedicamentRepository extends JpaRepository<PrescriptionMedicament, UUID> {
}
