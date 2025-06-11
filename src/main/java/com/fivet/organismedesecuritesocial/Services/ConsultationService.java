package com.fivet.organismedesecuritesocial.Services;


import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import com.fivet.organismedesecuritesocial.Repositories.AssureRepository;
import com.fivet.organismedesecuritesocial.Repositories.GeneralisteRepository;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import com.fivet.organismedesecuritesocial.Repositories.SpecialisteRepository;
import com.fivet.organismedesecuritesocial.Services.Consultation.CreationConsultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.LectureConsultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.ModificationConsultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.SuppressionConsultation;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.ConsultationDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.ConsulterDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.ModifierConsultationDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.DtoMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ConsultationService {
    @Autowired
    private CreationConsultation creationConsultation;
    @Autowired
    private SuppressionConsultation suppressionConsultation;
    @Autowired
    private ModificationConsultation modificationConsultation;
    @Autowired
    private LectureConsultation lectureConsultation;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private MedecinRepository medecinRepository;
    @Autowired
    private AssureRepository assureRepository;

    @Autowired
    private FeuilleMaladieService feuilleMaladieService;
    @Autowired
    private SpecialisteRepository specialisteRepository;
    @Autowired
    private GeneralisteRepository generalisteRepository;

    @Transactional
    public ConsultationDTO creerConsultation(ConsulterDTO consultation){
        // enregistrement de la consultation
        Consultation newConsultation = consultation.getConsultation();
        newConsultation.setMedecin(medecinRepository.findById(consultation.getIdMedecin()).get());
        newConsultation.setAssure(assureRepository.findById(consultation.getIdAssure()).get());
        creationConsultation.creerConsultation(newConsultation);

        // enregistrement des prescriptions
        consultation.getPrescriptions().stream().forEach(prescription -> {
            prescription.setConsultation(consultation.getConsultation());
            prescriptionService.AjouterPrescription(prescription);
        });

        // enregistrement de la feuille de maladie
        FeuilleMaladie newFeuilleMaladie = new FeuilleMaladie();
        newFeuilleMaladie.setConsultation(newConsultation);
        newFeuilleMaladie.setModeRemboursement(consultation.getModeRemboursement());
        if (specialisteRepository.existsById(consultation.getIdMedecin())){
            newFeuilleMaladie.setTaux(80);
        }else if (generalisteRepository.existsById(consultation.getIdMedecin())){
            newFeuilleMaladie.setTaux(100);
        }
        newFeuilleMaladie.setCodeAssurance("azerty");
        newFeuilleMaladie.setDateEmission(LocalDate.now());
        newFeuilleMaladie.setEtatRemborursement("En attente");
        feuilleMaladieService.creationFeuilleMaladie(newFeuilleMaladie);

        return DtoMapper.toConsultationDTO(newConsultation);
    }

    @Transactional
    public Boolean supprimerConsultation(Consultation consultation){
        return suppressionConsultation.supprimerConsultation(consultation);
    }

    @Transactional
    public ConsultationDTO modifierConsultation(ModifierConsultationDTO modifierConsultationDTO){
        return DtoMapper.toConsultationDTO(modificationConsultation.modifierConsultation(modifierConsultationDTO.getConsultation(), modifierConsultationDTO.getPrescriptions(), modifierConsultationDTO.getIdConsultation()));
    }

    @Transactional
    public ConsultationDTO lectureConsultation(UUID id){
        return DtoMapper.toConsultationDTO(lectureConsultation.lectureConsultation(id));
    }

    @Transactional
    public List<ConsultationDTO> lectureConsultationParAssure(UUID id){
        return DtoMapper.toConsultationDTOList(lectureConsultation.lectureConsultationParAssure(id));
    }

    @Transactional
    public List<ConsultationDTO> lectureConsultationParMedecin(UUID id){
        return DtoMapper.toConsultationDTOList(lectureConsultation.lectureConsultationParMedecin(id));
    }

    @Transactional
    public List<ConsultationDTO> lectureConsultation(){
        return DtoMapper.toConsultationDTOList(lectureConsultation.lectureConsultation());
    }

}

