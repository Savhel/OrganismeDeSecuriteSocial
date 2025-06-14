package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(nullable = false)
    private LocalDate dateConsultation;
    @NonNull
    @Column(nullable = false)
    private LocalTime heureDeConsultation;
    @NonNull
    @Column(nullable = false)
    private String diagnostic;
    @NonNull
    @Column(nullable = false)
    private String soins;
    @NonNull
    @Column(nullable = false)
    private String motif;
    @NonNull
    @Column(nullable = false)
    private Long Prix;

    @ManyToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;

    @ManyToOne
    @JoinColumn(name = "idAssure")
    private Assure assure;

    @OneToMany(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Prescription> prescriptions;

    @OneToOne(mappedBy = "consultation", cascade = CascadeType.ALL, orphanRemoval = true)
    private FeuilleMaladie feuilleMaladie;
}

