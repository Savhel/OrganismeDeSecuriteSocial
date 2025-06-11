package com.fivet.organismedesecuritesocial.Services.FeuilleMaladie;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuppressionFeuilleMaladie {

    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;

    public Boolean deleteFeuilleMaladie(UUID id) {
        if (feuilleMaladieRepository.existsById(id)) {
            feuilleMaladieRepository.deleteById(id);
            return true;
        } else {
            throw new UUIDNotExist("Cette Feuille de maladie n'existe pas");
        }
    }
}

