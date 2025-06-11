package com.fivet.organismedesecuritesocial.Services.Prescription;

import com.fivet.organismedesecuritesocial.Exceptions.SuppressionImpossible;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import com.fivet.organismedesecuritesocial.Repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuppressionPrescription {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Boolean deletePrescription(Prescription prescription) {
        if (prescriptionRepository.existsById(prescription.getId())) {
            prescriptionRepository.deleteById(prescription.getId());
            return true;
        }
        throw new SuppressionImpossible(" il s'agit de quelle prescription ??");
    }

}
