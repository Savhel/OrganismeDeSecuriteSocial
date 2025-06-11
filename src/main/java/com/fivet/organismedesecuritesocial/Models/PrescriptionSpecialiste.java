package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionSpecialiste {

    @Id
    private UUID idPrescription;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPrescription")
    private Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "idSpecialiste")
    private Specialiste specialiste;
}
