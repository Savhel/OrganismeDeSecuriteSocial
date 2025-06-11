package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementDTOVirement {
    @NonNull
    private UUID idFeuilleMaladie;

    @NonNull
    private RemboursementVirement remboursementVirement;
}
