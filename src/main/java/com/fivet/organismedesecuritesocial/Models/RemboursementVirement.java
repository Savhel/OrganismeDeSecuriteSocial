package com.fivet.organismedesecuritesocial.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementVirement {

    @Id
    private UUID idRemboursement;

    @NonNull
    @Column(nullable = false)
    private String NumeroDeCompte;

    @NonNull
    @Column(nullable = false)
    private String NomDeBanque;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idRemboursement")
    private Remboursement remboursement;

}


