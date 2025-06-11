package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Specialiste {

    @Id
    private UUID idPersonne;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPersonne")
    private Medecin medecin;

    @NonNull
    @Column(nullable = false)
    private String specialite;

    @NonNull
    @Column(nullable = false)
    private String domaineIntervention;
}
