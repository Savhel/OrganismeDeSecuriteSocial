    package com.fivet.organismedesecuritesocial.Models;

    import jakarta.persistence.*;
    import jakarta.validation.Valid;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import lombok.*;

    import java.time.LocalDate;
    import java.util.UUID;

    @RequiredArgsConstructor
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Entity
    public class Personne {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID idPersonne;

        @NonNull
        @Valid
        @NotNull(message = "Les informations de l’assuré sont obligatoires.")
        @Column(nullable = false)
        private String motDePasse;

        @NonNull
        @Column(nullable = false)
        private String nom;

        @NonNull
        @Column(nullable = false)
        private String prenom;

        @Valid
        @Column(unique = true, nullable = false)
        @Email(message = "L’adresse e-mail doit être valide.")
        @NotBlank(message = "L’e-mail est obligatoire.")
        private String mail;

        @NonNull
        @Column(nullable = false)
        private LocalDate DateNaiss;

        @NonNull
        @Column(nullable = false)
        private String LieuNaiss;

        @Column(unique = true, nullable = false)
        private String NumeroCNI;

        @NotNull(message = "Le numero de securte social est obligatoire.")
        @Column(unique = true, nullable = false)
        private String NumeroSecuriteSociale;

        @Column(nullable = false)
        private String Adresse;

        @Column(unique = true, nullable = false)
        private String Telephone;


    }

