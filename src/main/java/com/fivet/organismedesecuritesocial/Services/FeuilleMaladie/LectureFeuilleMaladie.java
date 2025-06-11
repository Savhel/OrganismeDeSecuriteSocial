package com.fivet.organismedesecuritesocial.Services.FeuilleMaladie;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureFeuilleMaladie {

    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;

    public FeuilleMaladie lectureFeuilleMaladie(UUID id) {
        return feuilleMaladieRepository.findById(id)
                .orElseThrow(() -> new UUIDNotExist("Cette Feuille de maladie n'existe pas"));
    }

    public List<FeuilleMaladie> lectureFeuilleMaladie() {
        return feuilleMaladieRepository.findAll();
    }

}

