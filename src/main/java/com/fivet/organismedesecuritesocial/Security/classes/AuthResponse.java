package com.fivet.organismedesecuritesocial.Security.classes;

import com.fivet.organismedesecuritesocial.Models.Personne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String jwt;
    private Personne personne;

}