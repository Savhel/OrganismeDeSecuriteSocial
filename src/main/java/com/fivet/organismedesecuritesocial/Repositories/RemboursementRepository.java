package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RemboursementRepository extends JpaRepository<Remboursement, UUID> {
}
