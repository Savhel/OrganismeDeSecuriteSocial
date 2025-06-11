package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Models.Remboursement;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementCashDTO {

    @NonNull
    private UUID idRemboursement;

    @NonNull
    private String lieuRemboursement;

    @NonNull
    private LocalDate dateRemboursement;

    @NonNull
    private FeuilleMaladieDTO feuilleMaladie;
}
