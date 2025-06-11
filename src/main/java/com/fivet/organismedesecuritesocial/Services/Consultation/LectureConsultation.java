package com.fivet.organismedesecuritesocial.Services.Consultation;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureConsultation {

    @Autowired
    private ConsultationRepository consultationRepository;
    public Consultation lectureConsultation(UUID id){
        return consultationRepository.findById(id).get();
    }

    public List<Consultation> lectureConsultation(){
        return consultationRepository.findAll();
    }

    public List<Consultation> lectureConsultationParAssure(UUID id){
        return consultationRepository.findByAssure_IdPersonne(id);
    }

    public List<Consultation> lectureConsultationParMedecin(UUID id){
        return consultationRepository.findByMedecin_IdPersonne(id);
    }
}
