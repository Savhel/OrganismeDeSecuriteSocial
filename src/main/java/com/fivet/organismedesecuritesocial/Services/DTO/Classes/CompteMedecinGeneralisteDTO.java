package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Models.Medecin;
import com.fivet.organismedesecuritesocial.Models.Personne;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteMedecinGeneralisteDTO {
    @NonNull
    private Personne personne;
    @NonNull
    private Medecin medecin;
    @NonNull
    private Generaliste generaliste;
}
