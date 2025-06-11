package com.fivet.organismedesecuritesocial.Services.Personne.Modification;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationImpossible;
import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.AssureRepository;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ModifierAssure implements ModifierAccountInterface<Assure>{

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private AssureRepository assureRepository;


    @Override
    public Assure modifierAccount(Assure assure, UUID idPersonne) {
        Optional<Personne> oldPersonne = personneRepository.findByIdPersonne(idPersonne);

        if(oldPersonne.isPresent()){
            Assure newAssure = new Assure();
            newAssure.setIdPersonne(oldPersonne.get().getIdPersonne());
            newAssure.setPersonne(oldPersonne.get());
            newAssure.setProfession(assure.getProfession());
            newAssure.setConsultations(assure.getConsultations());
            newAssure.setMedecintraitant(assure.getMedecintraitant());
            newAssure.setSituationMatrimoniale(assure.getSituationMatrimoniale());
            return assureRepository.save(newAssure);

        }
        throw new ModificationImpossible("Une erreur est survenue lors de la modification de vos informations");
    }
}
