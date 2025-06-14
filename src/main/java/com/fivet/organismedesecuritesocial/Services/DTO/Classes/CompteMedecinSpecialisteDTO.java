package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Generaliste;
import com.fivet.organismedesecuritesocial.Models.Medecin;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Models.Specialiste;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteMedecinSpecialisteDTO {

    @NonNull
    private Personne personne;
    @NonNull
    private Medecin medecin;
    @NonNull
    private Specialiste specialiste;
}
