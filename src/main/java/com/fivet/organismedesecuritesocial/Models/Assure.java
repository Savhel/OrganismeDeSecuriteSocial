package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Assure {

    @Id
    private UUID idPersonne;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPersonne")
    private Personne personne;

    @NonNull
    @Column(nullable = false)
    private String profession;

    @NonNull
    @Column(nullable = false)
    private String situationMatrimoniale;

    @ManyToOne
    @JoinColumn(name = "medecintraitant")
    private Medecin medecintraitant;

    @OneToMany(mappedBy = "assure")
    private List<Consultation> consultations;
}
