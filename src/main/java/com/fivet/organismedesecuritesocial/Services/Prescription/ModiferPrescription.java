package com.fivet.organismedesecuritesocial.Services.Prescription;


import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import com.fivet.organismedesecuritesocial.Repositories.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ModiferPrescription {


    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription modifierPrescription(Prescription prescription, UUID id) {
        if (prescriptionRepository.findById(id).isPresent()){
            Prescription prescription1 = prescriptionRepository.findById(id).get();
            prescription1.setInstructions(prescription.getInstructions());
            prescription1.setMedicament(prescription.getMedicament());
            prescription1.setDosage(prescription.getDosage());
            prescription1.setSpecialiste(prescription.getSpecialiste());
            return prescriptionRepository.save(prescription1);
        }

        throw new UUIDNotExist(" Il s'agit de quelle prescription ??");
    }
}
