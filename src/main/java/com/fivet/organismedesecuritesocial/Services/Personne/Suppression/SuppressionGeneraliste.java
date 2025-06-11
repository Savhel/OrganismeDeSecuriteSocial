package com.fivet.organismedesecuritesocial.Services.Personne.Suppression;

import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Repositories.GeneralisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuppressionGeneraliste implements SuppressionAccountInterface<Generaliste> {
    @Autowired
    private GeneralisteRepository generalisteRepository;
    @Override
    public Boolean supprimerAccount(UUID idPersonne) {
        generalisteRepository.deleteMedecinByIdPersonne(idPersonne);
        return true;
    }
}
