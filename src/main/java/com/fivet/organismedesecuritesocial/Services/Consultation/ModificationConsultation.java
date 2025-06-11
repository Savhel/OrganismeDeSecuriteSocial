package com.fivet.organismedesecuritesocial.Services.Consultation;

import com.fivet.organismedesecuritesocial.Exceptions.ModificationDeConsultationImpossible;
import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import com.fivet.organismedesecuritesocial.Repositories.ConsultationRepository;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import com.fivet.organismedesecuritesocial.Repositories.PrescriptionRepository;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladieService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class ModificationConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private FeuilleMaladieService feuilleMaladieService;

    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;

    public Consultation modifierConsultation(Consultation consultation, List<Prescription> prescriptions, UUID idConsultation){

        if (consultationRepository.findById(idConsultation).isPresent()){
            Consultation oldConsultation = consultationRepository.findById(idConsultation).get();
            if (LocalDate.now().isAfter(oldConsultation.getDateConsultation()) || oldConsultation.getHeureDeConsultation().isBefore(LocalTime.now().minusMinutes(5)) || !feuilleMaladieRepository.findById(idConsultation).get().getEtatRemborursement().equals("attente") ){
                throw new ModificationDeConsultationImpossible("C'est deja une fraude vous ne pouvez plus modifier cette consultation");
            }
            Consultation newConsultation = new Consultation();
            newConsultation.setId(idConsultation);
            newConsultation.setHeureDeConsultation(LocalTime.now());
            newConsultation.setDateConsultation(LocalDate.now());
            newConsultation.setDiagnostic(consultation.getDiagnostic());
            newConsultation.setMotif(consultation.getMotif());
            newConsultation.setSoins(consultation.getSoins());
            prescriptions.stream().forEach(prescription -> {
                prescription.setConsultation(newConsultation);
                prescriptionRepository.save(prescription);
            });
            newConsultation.setPrix(consultation.getPrix());

            // enregistrement de la feuille de maladie
            FeuilleMaladie newFeuilleMaladie = new FeuilleMaladie();
            newFeuilleMaladie.setConsultation(newConsultation);
            newFeuilleMaladie.setDateEmission(LocalDate.now());
            newFeuilleMaladie.setEtatRemborursement("En attente");
            consultationRepository.save(newConsultation);
            feuilleMaladieService.creationFeuilleMaladie(newFeuilleMaladie);
            return newConsultation;
        }

        throw new UUIDNotExist("Cette consultation n'existe pas ");
    }
}
