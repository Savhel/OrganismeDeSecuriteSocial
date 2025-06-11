package com.fivet.organismedesecuritesocial.Services.Personne.Creation;

import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CreatePersonne implements CreateAccountInterface<Personne>{

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Personne createAccount(Personne personne) {

        personne.setMotDePasse(passwordEncoder.encode(personne.getMotDePasse()));
        return personneRepository.save(personne);
    }
}
