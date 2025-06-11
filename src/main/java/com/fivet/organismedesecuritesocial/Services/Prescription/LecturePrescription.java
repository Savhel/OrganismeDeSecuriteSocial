package com.fivet.organismedesecuritesocial.Services.Prescription;

import com.fivet.organismedesecuritesocial.Models.Prescription;
import com.fivet.organismedesecuritesocial.Repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LecturePrescription {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription lecturePrescription(UUID id) {
        return prescriptionRepository.findById(id).get();
    }

    public List<Prescription> lecturePrescription() {
        return prescriptionRepository.findAll();
    }
}
