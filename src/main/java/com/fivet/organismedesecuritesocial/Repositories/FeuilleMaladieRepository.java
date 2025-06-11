package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FeuilleMaladieRepository extends JpaRepository<FeuilleMaladie, UUID> {

}
