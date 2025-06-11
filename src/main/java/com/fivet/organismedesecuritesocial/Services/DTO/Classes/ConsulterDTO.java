package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsulterDTO {

    @NonNull
    private UUID idAssure;

    @NonNull
    private UUID idMedecin;

    @NonNull
    private Consultation consultation;

    @NonNull
    private String modeRemboursement;

    private List<Prescription> prescriptions;
}
