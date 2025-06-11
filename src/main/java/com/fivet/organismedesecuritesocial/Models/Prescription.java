package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "id_consultation")
    private Consultation consultation;


    @Column(nullable = false)
    private String mediament;

    @Column(nullable = false)
    private String dosage;

    @ManyToOne
    @JoinColumn(name = "idSpecialiste")
    private Specialiste specialiste;

}


