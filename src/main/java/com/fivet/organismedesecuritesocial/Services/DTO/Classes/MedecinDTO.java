package com.fivet.organismedesecuritesocial.Services.DTO.Classes;

import lombok.*;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MedecinDTO {

    @NonNull
    private UUID id;

    @NonNull
    private String nom;

    private List<AssureDTO> patients;

}

