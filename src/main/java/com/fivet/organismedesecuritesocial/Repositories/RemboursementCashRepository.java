package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RemboursementCashRepository extends JpaRepository<RemboursementCash, UUID> {
}
