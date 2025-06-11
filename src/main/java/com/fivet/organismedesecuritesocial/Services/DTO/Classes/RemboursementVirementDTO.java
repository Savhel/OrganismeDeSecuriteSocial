package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementVirementDTO {

    @NonNull
    private UUID idRemboursement;

    @NonNull
    private String NumeroDeCompte;

    @NonNull
    private String NomDeBanque;

    @NonNull
    private LocalDate dateRemboursement;

    @NonNull
    private FeuilleMaladieDTO feuilleMaladie;
}
