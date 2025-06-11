package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RemboursementVirementRepository extends JpaRepository<RemboursementVirement, UUID> {
}
