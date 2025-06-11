package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PrescriptionMedicament {
    @Id
    private UUID idPrescription;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPrescription")
    private Prescription prescription;

    @NonNull
    @Column(nullable = false)
    private String mediament;

    @NonNull
    @Column(nullable = false)
    private String dosage;
}
