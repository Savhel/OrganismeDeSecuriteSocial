package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
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

    @NonNull
    private String profession;

    @NonNull
    private String situationMatrimoniale;

    @NonNull
    private String mail;

    @NonNull
    private LocalDate DateNaiss;

    @NonNull
    private String LieuNaiss;

    @NonNull
    private String NumeroCNI;

    @NonNull
    private String NumeroSecuriteSociale;

    private MedecinLiteDTO medecintraitant;

}
