package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.Assure;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedecinAssureDTO {
    @NonNull
    private UUID idMedecin;

    @NonNull
    private Assure assure;
}
