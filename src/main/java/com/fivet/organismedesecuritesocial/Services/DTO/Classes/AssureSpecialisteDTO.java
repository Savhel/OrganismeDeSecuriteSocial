package com.fivet.organismedesecuritesocial.Services.DTO.Classes;


import com.fivet.organismedesecuritesocial.Models.Specialiste;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssureSpecialisteDTO extends AssureMedecinDTO{
    @NonNull
    private Specialiste specialiste;
}
