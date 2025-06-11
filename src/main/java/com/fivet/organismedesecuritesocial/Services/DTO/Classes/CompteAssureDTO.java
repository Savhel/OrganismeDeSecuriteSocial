package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Personne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteAssureDTO {

    @Valid
    @NotNull(message = "Les informations personnelles sont obligatoires.")
    private Personne personne;

    @Valid
    @NotNull(message = "Les informations de l’assuré sont obligatoires.")
    private Assure assure;
}


