package com.fivet.organismedesecuritesocial.Services.Personne.Suppression;

import com.fivet.organismedesecuritesocial.Models.Specialiste;
import com.fivet.organismedesecuritesocial.Repositories.SpecialisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuppressionSpecialiste implements SuppressionAccountInterface<Specialiste>{
    @Autowired
    private SpecialisteRepository specialisteRepository;
    @Override
    public Boolean supprimerAccount(UUID idPersonne) {
        specialisteRepository.deleteSpecialisteByIdPersonne(idPersonne);
        return true;
    }
}
