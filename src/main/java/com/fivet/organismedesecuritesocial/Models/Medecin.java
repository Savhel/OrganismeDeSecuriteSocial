package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medecin {

    @Id
    private UUID idPersonne;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPersonne")
    private Personne personne;

    @NonNull
    @Column(nullable = false)
    private String numeroRPPS;
    @NonNull
    @Column(nullable = false)
    private String adresseCabinet;

    @OneToMany(mappedBy = "medecin")
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "medecintraitant")
    private List<Assure> patients;

}

