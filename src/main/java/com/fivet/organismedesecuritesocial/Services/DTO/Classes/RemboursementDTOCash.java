package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementDTOCash {

    @NonNull
    private UUID idFeuilleMaladie;

    @NonNull
    private RemboursementCash remboursementCash;

}
