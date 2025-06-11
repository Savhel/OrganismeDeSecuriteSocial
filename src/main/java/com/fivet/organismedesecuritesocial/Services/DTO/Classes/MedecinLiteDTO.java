package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import lombok.*;

import java.util.UUID;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class MedecinLiteDTO {

    @NonNull
    private UUID id;

    private String nom;

    private String prenom;

    @NonNull
    private String NumeroRPPS;

    @NonNull
    private String AdresseCabinet;
}
