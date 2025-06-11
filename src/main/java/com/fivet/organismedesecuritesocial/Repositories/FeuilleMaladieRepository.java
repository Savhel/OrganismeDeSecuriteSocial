package com.fivet.organismedesecuritesocial.Repositories;

import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FeuilleMaladieRepository extends JpaRepository<FeuilleMaladie, UUID> {


    @Query("SELECT f FROM FeuilleMaladie f " +
            "LEFT JOIN FETCH f.consultation c " +
            "LEFT JOIN FETCH c.medecin m " +
            "LEFT JOIN FETCH c.assure a " +
            "LEFT JOIN FETCH c.prescriptions p " +
            "WHERE f.id = :id")
    FeuilleMaladie findByIdWithDetails(@Param("id") UUID id);


    @Query("SELECT DISTINCT f FROM FeuilleMaladie f " +
            "LEFT JOIN FETCH f.consultation c " +
            "LEFT JOIN FETCH c.medecin m " +
            "LEFT JOIN FETCH c.assure a")
    List<FeuilleMaladie> findAllWithDetails();


    List<FeuilleMaladie> findByEtatRemborursement(String etatRemboursement);


    List<FeuilleMaladie> findByCodeAssurance(String codeAssurance);


    @Query("SELECT f FROM FeuilleMaladie f " +
            "JOIN f.consultation c " +
            "WHERE c.medecin.idPersonne = :medecinId")
    List<FeuilleMaladie> findByMedecinId(@Param("medecinId") UUID medecinId);

    @Query("SELECT f FROM FeuilleMaladie f " +
            "JOIN f.consultation c " +
            "WHERE c.assure.idPersonne = :assureId")
    List<FeuilleMaladie> findByAssureId(@Param("assureId") UUID assureId);


    long countByEtatRemborursement(String etatRemboursement);
}
