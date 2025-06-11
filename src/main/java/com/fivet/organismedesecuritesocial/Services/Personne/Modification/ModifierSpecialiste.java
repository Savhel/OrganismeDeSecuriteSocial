package com.fivet.organismedesecuritesocial.Services.Personne.Modification;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationImpossible;
import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Models.Specialiste;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import com.fivet.organismedesecuritesocial.Repositories.SpecialisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ModifierSpecialiste implements ModifierAccountInterface<Specialiste>{

    @Autowired
    private SpecialisteRepository specialisteRepository;

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Specialiste modifierAccount(Specialiste specialiste, UUID idPersonne) {
        Optional<Personne> oldPersonne = personneRepository.findByIdPersonne(idPersonne);

        if (oldPersonne.isPresent()) {
            Specialiste newSpecialiste = new Specialiste();
            newSpecialiste.setMedecin(specialiste.getMedecin());
            newSpecialiste.setIdPersonne(oldPersonne.get().getIdPersonne());
            newSpecialiste.setSpecialite(specialiste.getSpecialite());
            newSpecialiste.setDomaineIntervention(specialiste.getDomaineIntervention());
            return specialisteRepository.save(newSpecialiste);
        }
        throw new ModificationImpossible("Une erreur est survenue lors de la modification de vos informations");
    }
}
