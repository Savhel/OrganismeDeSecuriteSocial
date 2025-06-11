package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class ModifierConsultationDTO {

    @NonNull
    private Consultation consultation;

    private List<Prescription> prescriptions;

    @NonNull
    private UUID idConsultation;
}
