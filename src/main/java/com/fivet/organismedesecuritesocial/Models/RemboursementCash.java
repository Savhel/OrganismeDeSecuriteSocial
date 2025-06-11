package com.fivet.organismedesecuritesocial.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementCash {

    @Id
    private UUID idRemboursement;

    @NonNull
    @Column(nullable = false)
    private String lieuRemboursement;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idRemboursement")
    private Remboursement remboursement;
}
