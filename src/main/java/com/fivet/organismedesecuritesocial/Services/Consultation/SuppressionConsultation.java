package com.fivet.organismedesecuritesocial.Services.Consultation;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppressionConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;

    public Boolean supprimerConsultation(Consultation consultation){
        consultationRepository.delete(consultation);
        return true;
    }
}
