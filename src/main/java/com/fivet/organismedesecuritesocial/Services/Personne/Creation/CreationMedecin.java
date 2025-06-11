package com.fivet.organismedesecuritesocial.Services.Personne.Creation;

import com.fivet.organismedesecuritesocial.Models.Medecin;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreationMedecin implements CreateAccountInterface<Medecin>{

    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Medecin createAccount(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
}
