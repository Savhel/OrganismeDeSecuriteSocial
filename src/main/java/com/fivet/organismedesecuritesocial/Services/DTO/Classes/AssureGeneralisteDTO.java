package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import com.fivet.organismedesecuritesocial.Models.Generaliste;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssureGeneralisteDTO extends AssureMedecinDTO{

    @NonNull
    private Generaliste generaliste;
}
