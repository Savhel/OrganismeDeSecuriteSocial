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
public class Remboursement {

    @Id
    private UUID idRemboursement;

    @NonNull
    @Column(nullable = false)
    private LocalDate dateRemboursement;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idRemboursement",unique = true)
    private FeuilleMaladie feuilleMaladie;

}

