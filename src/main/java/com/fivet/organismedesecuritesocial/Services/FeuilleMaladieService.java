package com.fivet.organismedesecuritesocial.Services;


import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.FeuilleMaladieDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.DtoMapper;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.CreationFeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.LectureFeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.ModificationFeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.SuppressionFeuilleMaladie;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FeuilleMaladieService {

    @Autowired
    private CreationFeuilleMaladie creationFeuilleMaladie;

    @Autowired
    private LectureFeuilleMaladie lectureFeuilleMaladie;

    @Autowired
    private ModificationFeuilleMaladie modificationFeuilleMaladie;
    @Autowired
    private SuppressionFeuilleMaladie suppressionFeuilleMaladie;

    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;


    public FeuilleMaladieDTO creationFeuilleMaladie(FeuilleMaladie feuilleMaladie) {
        return DtoMapper.toFeuilleMaladieDTO(creationFeuilleMaladie.saveFeuilleMaladie(feuilleMaladie));
    }
    public FeuilleMaladieDTO lectureFeuilleMaladie(UUID id) {
        return DtoMapper.toFeuilleMaladieDTO(lectureFeuilleMaladie.lectureFeuilleMaladie(id));
    }
    public FeuilleMaladieDTO modificationFeuilleMaladie( FeuilleMaladie feuilleMaladie, UUID id) {
        return DtoMapper.toFeuilleMaladieDTO(modificationFeuilleMaladie.updateFeuilleMaladie(feuilleMaladie, id));
    }
    public Boolean suppressionFeuilleMaladie(UUID id) {
        return suppressionFeuilleMaladie.deleteFeuilleMaladie(id);
    }

    public List<FeuilleMaladieDTO> lectureFeuilleMaladie() {
        return DtoMapper.toFeuilleMaladieDTOList(lectureFeuilleMaladie.lectureFeuilleMaladie());
    }



    @Transactional(readOnly = true)
    public FeuilleMaladie findByIdWithDetails(UUID id) {
        return feuilleMaladieRepository.findByIdWithDetails(id);
    }

    /**
     * Trouve toutes les feuilles de maladie
     */
    @Transactional(readOnly = true)
    public List<FeuilleMaladie> findAll() {
        return feuilleMaladieRepository.findAll();
    }

    /**
     * Sauvegarde une feuille de maladie
     */
    public FeuilleMaladie save(FeuilleMaladie feuilleMaladie) {
        return feuilleMaladieRepository.save(feuilleMaladie);
    }

    /**
     * Supprime une feuille de maladie
     */
    public void deleteById(UUID id) {
        feuilleMaladieRepository.deleteById(id);
    }

    /**
     * Trouve les feuilles de maladie par état de remboursement
     */
    @Transactional(readOnly = true)
    public List<FeuilleMaladie> findByEtatRemboursement(String etat) {
        return feuilleMaladieRepository.findByEtatRemborursement(etat);
    }

    /**
     * Trouve les feuilles de maladie par code d'assurance
     */
    @Transactional(readOnly = true)
    public List<FeuilleMaladie> findByCodeAssurance(String codeAssurance) {
        return feuilleMaladieRepository.findByCodeAssurance(codeAssurance);
    }


}
