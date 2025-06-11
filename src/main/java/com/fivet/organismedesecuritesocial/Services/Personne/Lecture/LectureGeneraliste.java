package com.fivet.organismedesecuritesocial.Services.Personne.Lecture;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Repositories.GeneralisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureGeneraliste implements LectureAccountInterface<Generaliste>{

    @Autowired
    private GeneralisteRepository generalisteRepository;

    @Override
    public Generaliste lireAccount(UUID idPersonne) {
        if (generalisteRepository.findByIdPersonne(idPersonne).isPresent()){
            return generalisteRepository.findByIdPersonne(idPersonne).get();
        }
        throw new UUIDNotExist("Nous ne connaissons pas cet utilisateur");
    }

    @Override
    public List<Generaliste> lireAccounts() {
        return generalisteRepository.findAll();
    }
}
