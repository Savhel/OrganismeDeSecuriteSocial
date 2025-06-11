package com.fivet.organismedesecuritesocial.Services.Personne.Modification;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationImpossible;
import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.GeneralisteRepository;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ModifierGeneraliste implements ModifierAccountInterface<Generaliste>{

    @Autowired
    private GeneralisteRepository generalisteRepository;
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Generaliste modifierAccount(Generaliste generaliste, UUID idPersonne) {
        Optional<Personne> oldPersonne = personneRepository.findByIdPersonne(idPersonne);

        if(oldPersonne.isPresent()){
            Generaliste newGeneraliste = new Generaliste();
            newGeneraliste.setIdPersonne(generaliste.getIdPersonne());
            newGeneraliste.setMedecin(generaliste.getMedecin());
            newGeneraliste.setSecteur(generaliste.getSecteur());
            return generalisteRepository.save(newGeneraliste);
        }
        throw new ModificationImpossible("Une erreur est survenue lors de la modification de vos informations");
    }
}
