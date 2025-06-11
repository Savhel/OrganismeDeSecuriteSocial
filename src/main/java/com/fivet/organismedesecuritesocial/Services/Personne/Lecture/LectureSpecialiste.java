package com.fivet.organismedesecuritesocial.Services.Personne.Lecture;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Specialiste;
import com.fivet.organismedesecuritesocial.Repositories.SpecialisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureSpecialiste implements LectureAccountInterface<Specialiste> {

    @Autowired
    private SpecialisteRepository specialisteRepository;

    @Override
    public Specialiste lireAccount(UUID idPersonne) {
        if (specialisteRepository.findByIdPersonne(idPersonne).isPresent()){
            return specialisteRepository.findByIdPersonne(idPersonne).get();
        }
        throw new UUIDNotExist("Nous ne connaissons pas cet utilisateur");
    }

    @Override
    public List<Specialiste> lireAccounts() {
        return specialisteRepository.findAll();
    }
}
