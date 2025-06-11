package com.fivet.organismedesecuritesocial.Services.Personne.Lecture;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Repositories.AssureRepository;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureAssure implements LectureAccountInterface<Assure> {
    @Autowired
    private AssureRepository assureRepository;
    @Autowired
    private MedecinRepository medecinRepository;

    @Override
    public Assure lireAccount(UUID idPersonne) {
        if(assureRepository.findByIdPersonne(idPersonne).isPresent()){
            return assureRepository.findByIdPersonne(idPersonne).get();
        }
        throw new UUIDNotExist("Nous ne connaissons pas cet utilisateur");
    }

    @Override
    public List<Assure> lireAccounts() {
        return assureRepository.findAll();
    }

    public List<Assure> lireAccounts(UUID idMedecinTraitant) {
        if (medecinRepository.findByIdPersonne(idMedecinTraitant).isPresent()){
            return assureRepository.getAssuresByMedecintraitant(medecinRepository.findByIdPersonne(idMedecinTraitant).get());
        }
        throw new UUIDNotExist("Nous ne connaissons pas cet utilisateur");
    }
}
