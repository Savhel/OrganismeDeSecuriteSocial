package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Models.Prescription;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDTO {

    @NonNull
    private UUID id;

    @NonNull
    private LocalDate dateConsultation;
    @NonNull
    private LocalTime HeureDeConsultation;
    @NonNull
    private String diagnostic;
    @NonNull
    private String Soins;
    @NonNull
    private String motif;
    @NonNull
    private Long Prix;

    @NonNull
    private MedecinLiteDTO medecin;

    @NonNull
    private List<PrescriptionDTO> prescriptions;
}
