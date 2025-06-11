package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Models.Specialiste;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PrescriptionDTO {
    @NonNull
    private UUID id;

    @NonNull
    private String instructions;

//    @NonNull
//    private ConsultationLiteDTO consultation;


    private String mediament;


    private String dosage;


    private SpecialisteDTO specialiste;
}
