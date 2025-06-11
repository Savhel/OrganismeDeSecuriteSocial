package com.fivet.organismedesecuritesocial.Services.Personne.Suppression;

import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuppressionPersonne implements SuppressionAccountInterface<Personne>{
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Boolean supprimerAccount(UUID idPersonne) {
        personneRepository.deletePersonneByIdPersonne(idPersonne);
        return true;
    }
}
