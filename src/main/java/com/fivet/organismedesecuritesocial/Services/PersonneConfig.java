package com.fivet.organismedesecuritesocial.Services;

import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Repositories.AssureRepository;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonneConfig implements UserDetailsService {

    @Autowired
    private PersonneRepository personneRepo;
    @Autowired
    private AssureRepository assureRepo;
    @Autowired
    private MedecinRepository medecinRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Looking for user with email: " + email);

        Personne personne = personneRepo.findByMail(email)
                .orElseThrow(() -> {
                    System.out.println("User not found with email: " + email);
                    return new UsernameNotFoundException("Utilisateur avec cet e-mail introuvable: " + email);
                });

        System.out.println("User found: " + personne.getNom() + " with ID: " + personne.getIdPersonne());

        List<GrantedAuthority> roles = new ArrayList<>();

        if (assureRepo.existsByIdPersonne(personne.getIdPersonne())) {
            roles.add(new SimpleGrantedAuthority("ROLE_ASSURE"));
            System.out.println("User has ROLE_ASSURE");
        }

        if (medecinRepo.existsByIdPersonne(personne.getIdPersonne())) {
            roles.add(new SimpleGrantedAuthority("ROLE_MEDECIN"));
            System.out.println("User has ROLE_MEDECIN");
        }
        System.out.println("User roles: " + roles);

        return new org.springframework.security.core.userdetails.User(
                personne.getMail(),
                personne.getMotDePasse(),
                roles
        );
    }
}