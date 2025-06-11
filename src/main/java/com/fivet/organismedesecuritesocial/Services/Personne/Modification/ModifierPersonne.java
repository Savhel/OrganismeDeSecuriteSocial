package com.fivet.organismedesecuritesocial.Services.Personne.Modification;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationImpossible;
import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ModifierPersonne implements ModifierAccountInterface<Personne> {

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Personne modifierAccount(Personne personne, UUID idPersonne) {
        Optional<Personne> oldPersonne = personneRepository.findByIdPersonne(idPersonne);

        if (oldPersonne.isPresent()){
            Personne newPerson = oldPersonne.get();
//            newPerson.setIdPersonne(personne.getIdPersonne());
            newPerson.setAdresse(personne.getAdresse());
            newPerson.setDateNaiss(personne.getDateNaiss());
            newPerson.setNom(personne.getNom());
            newPerson.setPrenom(personne.getPrenom());
            newPerson.setMail(personne.getMail());
            newPerson.setLieuNaiss(personne.getLieuNaiss());
            newPerson.setMotDePasse(passwordEncoder.encode(personne.getMotDePasse()));
            newPerson.setNumeroCNI(personne.getNumeroCNI());
            newPerson.setNumeroSecuriteSociale(personne.getNumeroSecuriteSociale());
            newPerson.setTelephone(personne.getTelephone());
            personneRepository.save(newPerson);
            return newPerson;
        }
        throw new ModificationImpossible("Une erreur est survenue lors de la modification de vos informations");
    }
}
