package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Personne;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class ChoisirMedecinTraitantDTO {

    @NonNull
    private UUID idPersonne;
    @NonNull
    private Assure assure;
    @NonNull
    private Personne personne;

}
