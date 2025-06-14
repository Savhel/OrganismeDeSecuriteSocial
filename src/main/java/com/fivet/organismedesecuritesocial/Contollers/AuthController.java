package com.fivet.organismedesecuritesocial.Contollers;

import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import com.fivet.organismedesecuritesocial.Security.JwtUtil;
import com.fivet.organismedesecuritesocial.Security.classes.AuthRequest;
import com.fivet.organismedesecuritesocial.Security.classes.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonneRepository personneRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        System.out.println("=== LOGIN REQUEST RECEIVED ===");
        System.out.println("Username: " + request.getNom());
        System.out.println("Password length: " + (request.getMotDePasse() != null ? request.getMotDePasse().length() : "null"));

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getNom(), request.getMotDePasse())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtil.generateToken(request.getNom());

            List<String> role = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            Personne personne = personneRepo.findByMail(request.getNom())
                    .orElseThrow(() -> {
                        return new UsernameNotFoundException("Utilisateur avec cet e-mail introuvable: " + request.getNom());
                    });

            System.out.println("=== LOGIN SUCCESSFUL ===");
            return ResponseEntity.ok(new AuthResponse(jwt, role, personne));

        } catch (Exception e) {
            System.out.println("=== LOGIN FAILED ===");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}