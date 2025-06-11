package com.fivet.organismedesecuritesocial.Services.Consultation;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationDeConsultationImpossible;
import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Repositories.ConsultationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Service
public class ModificationConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation modifierConsultation(Consultation consultation, UUID idConsultation){

        if (consultationRepository.findById(idConsultation).isPresent()){
            Consultation oldConsultation = consultationRepository.findById(idConsultation).get();
            if (LocalDate.now().isAfter(oldConsultation.getDateConsultation()) || oldConsultation.getHeureDeConsultation().isBefore(LocalTime.now().minusMinutes(10)) ){
                throw new ModificationDeConsultationImpossible("C'est deja une fraude vous ne pouvez plus modifier cette consultation");
            }
            Consultation newConsultation = new Consultation();
            newConsultation.setId(idConsultation);
            newConsultation.setHeureDeConsultation(consultation.getHeureDeConsultation());
            newConsultation.setDateConsultation(consultation.getDateConsultation());
            newConsultation.setAssure(consultation.getAssure());
            newConsultation.setDiagnostic(consultation.getDiagnostic());
            newConsultation.setFeuilleMaladie(consultation.getFeuilleMaladie());
            newConsultation.setMedecin(consultation.getMedecin());
            newConsultation.setMotif(consultation.getMotif());
            newConsultation.setSoins(consultation.getSoins());
            newConsultation.setPrescriptions(consultation.getPrescriptions());
            newConsultation.setPrix(consultation.getPrix());
            return consultationRepository.save(newConsultation);
        }

        throw new UUIDNotExist("Cette consultation n'existe pas ");
    }
}
