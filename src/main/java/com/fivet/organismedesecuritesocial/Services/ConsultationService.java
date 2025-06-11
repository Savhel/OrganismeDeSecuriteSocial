package com.fivet.organismedesecuritesocial.Services;


import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.CreationConsultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.LectureConsultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.ModificationConsultation;
import com.fivet.organismedesecuritesocial.Services.Consultation.SuppressionConsultation;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.ConsultationDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ConsultationDTO creerConsultation(Consultation consultation){
        return DtoMapper.toConsultationDTO(creationConsultation.creerConsultation(consultation));
    }

    public Boolean supprimerConsultation(Consultation consultation){
        return suppressionConsultation.supprimerConsultation(consultation);
    }

    public ConsultationDTO modifierConsultation(Consultation consultation, UUID uuid){
        return DtoMapper.toConsultationDTO(modificationConsultation.modifierConsultation(consultation, uuid));
    }
    public ConsultationDTO lectureConsultation(UUID id){
        return DtoMapper.toConsultationDTO(lectureConsultation.lectureConsultation(id));
    }
    public List<ConsultationDTO> lectureConsultation(){
        return DtoMapper.toConsultationDTOList(lectureConsultation.lectureConsultation());
    }

}

