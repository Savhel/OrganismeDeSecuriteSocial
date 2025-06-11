package com.fivet.organismedesecuritesocial.Services;

import com.fivet.organismedesecuritesocial.Models.Prescription;
import com.fivet.organismedesecuritesocial.Repositories.PrescriptionRepository;
import com.fivet.organismedesecuritesocial.Services.Prescription.CreationPrescription;
import com.fivet.organismedesecuritesocial.Services.Prescription.LecturePrescription;
import com.fivet.organismedesecuritesocial.Services.Prescription.ModiferPrescription;
import com.fivet.organismedesecuritesocial.Services.Prescription.SuppressionPrescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrescriptionService {

    @Autowired
    private CreationPrescription creationPrescription;
    @Autowired
    private LecturePrescription lecturePrescription;

    @Autowired
    private ModiferPrescription modiferPrescription;
    @Autowired
    private SuppressionPrescription suppressionPrescription;

    public Prescription AjouterPrescription(Prescription prescription) {
        return creationPrescription.savePrescription(prescription);
    }
    public Prescription LirePrescription(UUID id) {
        return lecturePrescription.lecturePrescription(id);
    }

    public List<Prescription> LirePrescription() {
        return lecturePrescription.lecturePrescription();
    }
    public Prescription ModifierPrescription(Prescription prescription, UUID id) {
        return modiferPrescription.modifierPrescription(prescription, prescription.getId());
    }
    public Boolean SupprimerPrescription(Prescription prescription) {
        return suppressionPrescription.deletePrescription(prescription) ;
    }

}
