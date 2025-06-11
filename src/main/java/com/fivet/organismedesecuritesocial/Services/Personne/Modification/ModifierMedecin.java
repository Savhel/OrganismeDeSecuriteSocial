package com.fivet.organismedesecuritesocial.Services.Personne.Modification;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationImpossible;
import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Models.Medecin;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ModifierMedecin implements ModifierAccountInterface<Medecin>{

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Medecin modifierAccount(Medecin medecin, UUID idPersonne) {
        Optional<Personne> oldPersonne = personneRepository.findByIdPersonne(idPersonne);

        if (oldPersonne.isPresent()){
            Medecin newMedecin =new Medecin();
            newMedecin.setIdPersonne(oldPersonne.get().getIdPersonne());
            newMedecin.setPersonne(oldPersonne.get());
            newMedecin.setNumeroRPPS(medecin.getNumeroRPPS());
            newMedecin.setPatients(medecin.getPatients());
            newMedecin.setConsultations(medecin.getConsultations());
            newMedecin.setAdresseCabinet(medecin.getAdresseCabinet());

            medecinRepository.save(newMedecin);
        }

        throw new ModificationImpossible("Une erreur est survenue lors de la modification de vos informations");
    }
}
