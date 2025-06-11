package com.fivet.organismedesecuritesocial.Services.Personne.Creation;

import com.fivet.organismedesecuritesocial.Models.Specialiste;
import com.fivet.organismedesecuritesocial.Repositories.SpecialisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreationSpecialiste implements CreateAccountInterface<Specialiste> {

    @Autowired
    private SpecialisteRepository specialisteRepository;



    @Override
    public Specialiste createAccount(Specialiste specialiste) {
        return specialisteRepository.save(specialiste);
    }
}
