package com.fivet.organismedesecuritesocial.Services.Personne.Creation;

import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Repositories.GeneralisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreationMedecinGeneraliste implements CreateAccountInterface<Generaliste> {

    @Autowired
    private GeneralisteRepository generalisteRepository;

    @Override
    public Generaliste createAccount(Generaliste generaliste) {
        return generalisteRepository.save(generaliste);
    }
}
