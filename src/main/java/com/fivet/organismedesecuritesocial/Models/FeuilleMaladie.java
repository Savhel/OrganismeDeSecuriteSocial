package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class FeuilleMaladie {

    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Consultation consultation;

    @NonNull
    @Column(nullable = false)
    private LocalDate dateEmission;
    @NonNull
    @Column(nullable = false)
    private String etatRemborursement;
    @NonNull
    @Column(nullable = false)
    private Integer taux;
    @NonNull
    @Column(nullable = false)
    private String modeRemboursement;
    @NonNull
    @Column(nullable = false)
    private String codeAssurance;

//    @OneToOne
//    @JoinColumn(name = "consultation_id", unique = true)
//    private Consultation consultation;

}

