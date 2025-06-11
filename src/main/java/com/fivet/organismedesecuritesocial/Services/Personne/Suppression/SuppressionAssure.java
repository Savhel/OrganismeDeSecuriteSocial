package com.fivet.organismedesecuritesocial.Services.Personne.Suppression;

import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Repositories.AssureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuppressionAssure implements SuppressionAccountInterface<Assure>{

    @Autowired
    private AssureRepository assureRepository;

    @Override
    public Boolean supprimerAccount(UUID idPersonne) {
        assureRepository.deleteAssuresByIdPersonne(idPersonne);
        return true;
    }
}
