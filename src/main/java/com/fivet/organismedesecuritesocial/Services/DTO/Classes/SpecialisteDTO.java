package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Medecin;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecialisteDTO {
    @NonNull
    private UUID idPersonne;

    @NonNull
    private MedecinDTO medecin;

    @NonNull
    private String specialite;

    @NonNull
    private String domaineIntervention;
}
