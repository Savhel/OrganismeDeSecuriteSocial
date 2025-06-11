package com.fivet.organismedesecuritesocial.Services.FeuilleMaladie;


import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ModificationFeuilleMaladie {

    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;

    public FeuilleMaladie updateFeuilleMaladie(FeuilleMaladie nouvelleFeuille, UUID id) {
        return feuilleMaladieRepository.findById(id)
                .map(existing -> {
                    existing.setCodeAssurance("azerty");
                    existing.setConsultation(nouvelleFeuille.getConsultation());
                    existing.setDateEmission(nouvelleFeuille.getDateEmission());
                    existing.setEtatRemborursement(nouvelleFeuille.getEtatRemborursement());
                    existing.setTaux(nouvelleFeuille.getTaux());
                    existing.setModeRemboursement(nouvelleFeuille.getModeRemboursement());
                    return feuilleMaladieRepository.save(existing);
                })
                .orElseThrow(() -> new UUIDNotExist("Cette Feuille de maladie n'existe pas"));
    }

}
