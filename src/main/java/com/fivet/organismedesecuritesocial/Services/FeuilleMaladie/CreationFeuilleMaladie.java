package com.fivet.organismedesecuritesocial.Services.FeuilleMaladie;

import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreationFeuilleMaladie {

    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;

    public FeuilleMaladie saveFeuilleMaladie(FeuilleMaladie feuilleMaladie) {
        return feuilleMaladieRepository.save(feuilleMaladie);
    }

}
