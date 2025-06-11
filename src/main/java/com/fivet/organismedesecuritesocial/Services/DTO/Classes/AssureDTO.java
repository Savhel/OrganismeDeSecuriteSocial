package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class AssureDTO {
    @NonNull
    private UUID id;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;

    private MedecinLiteDTO medecintraitant;

}
