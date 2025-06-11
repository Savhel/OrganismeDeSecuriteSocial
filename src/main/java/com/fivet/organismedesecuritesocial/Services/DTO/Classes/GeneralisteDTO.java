package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Medecin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneralisteDTO {

    @NonNull
    private UUID idPersonne;

    @NonNull
    private MedecinDTO medecin;

    @NonNull
    private String Secteur;
}
