package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeuilleMaladieDTO {

    @NonNull
    private UUID id;

    @NonNull
    private LocalDate dateEmission;
    @NonNull
    private String etatRemborursement;
    @NonNull
    private Integer taux;
    @NonNull
    private String modeRemboursement;
    @NonNull
    private String codeAssurance;

    @NonNull
    private ConsultationDTO consultation;
}
