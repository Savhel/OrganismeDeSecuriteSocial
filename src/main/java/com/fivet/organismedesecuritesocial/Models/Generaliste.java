package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Generaliste {
    @Id
    private UUID idPersonne;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPersonne")
    private Medecin medecin;

    @NonNull
    @Column(nullable = false)
    private String Secteur;
}
