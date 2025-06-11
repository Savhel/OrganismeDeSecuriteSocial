package com.fivet.organismedesecuritesocial.Services.Personne.Suppression;

import com.fivet.organismedesecuritesocial.Models.Medecin;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SuppressionMedecin implements SuppressionAccountInterface<Medecin>{
    @Autowired
    private MedecinRepository medecinRepository;
    @Override
    public Boolean supprimerAccount(UUID idPersonne) {
        medecinRepository.deleteMedecinByIdPersonne(idPersonne);
        return true;
    }
}
