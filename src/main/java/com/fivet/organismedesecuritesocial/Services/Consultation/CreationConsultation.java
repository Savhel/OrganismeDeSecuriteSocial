package com.fivet.organismedesecuritesocial.Services.Consultation;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreationConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation creerConsultation(Consultation consultation){
        return consultationRepository.save(consultation);
    }
}
