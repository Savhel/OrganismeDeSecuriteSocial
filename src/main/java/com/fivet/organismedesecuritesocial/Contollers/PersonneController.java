package com.fivet.organismedesecuritesocial.Contollers;

import com.fivet.organismedesecuritesocial.Services.DTO.Classes.CompteAssureDTO;
import com.fivet.organismedesecuritesocial.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personne")
public class PersonneController {

    @Autowired
    private PersonneService personneService;


    @PostMapping("/creation-de-compte")
    public ResponseEntity<?> creerCompte(@Validated @RequestBody CompteAssureDTO compteAssureDTO) {
        try {
            personneService.createNew(compteAssureDTO.getPersonne(), compteAssureDTO.getAssure());
            return ResponseEntity.status(HttpStatus.CREATED).body(compteAssureDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création du compte assuré : " + e.getMessage());
        }
    }

}
