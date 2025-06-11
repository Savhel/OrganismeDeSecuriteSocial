package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Medecin;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AssureMedecinDTO {

    @NonNull
    private UUID idPersonne;

    @NonNull
    private Medecin medecin;
}
