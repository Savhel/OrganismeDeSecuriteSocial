package com.fivet.organismedesecuritesocial.Contollers;

import com.fivet.organismedesecuritesocial.Models.Assure;
import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.*;
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


    @PostMapping("/creationAssure")
    public ResponseEntity<?> creerCompte(@Validated @RequestBody CompteAssureDTO compteAssureDTO) {
        try {
            System.out.println(compteAssureDTO);
            personneService.createNew(compteAssureDTO.getPersonne(), compteAssureDTO.getAssure());
            return ResponseEntity.status(HttpStatus.CREATED).body(compteAssureDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création du compte assuré : " + e.getMessage());
        }
    }

    @PostMapping("/creationDeMedecinGeneraliste")
    public ResponseEntity<?> creerGeneraliste(@Validated @RequestBody CompteMedecinGeneralisteDTO compteMedecinGeneralisteDTO) {
        try{
            System.out.println(compteMedecinGeneralisteDTO);
            personneService.createNew(compteMedecinGeneralisteDTO.getPersonne(),compteMedecinGeneralisteDTO.getMedecin(),compteMedecinGeneralisteDTO.getGeneraliste());
            return ResponseEntity.status(HttpStatus.CREATED).body(compteMedecinGeneralisteDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création du compte Medecin Generaliste : " + e.getMessage());
        }
    }

    @PostMapping("/creationDeMedecinSpecialiste")
    public ResponseEntity<?> creerSpecialiste(@Validated @RequestBody CompteMedecinSpecialisteDTO compteMedecinSpecialisteDTO) {
        try{
//            System.out.println(compteMedecinGeneralisteDTO);
            personneService.createNew(compteMedecinSpecialisteDTO.getPersonne(),compteMedecinSpecialisteDTO.getMedecin(),compteMedecinSpecialisteDTO.getSpecialiste());
            return ResponseEntity.status(HttpStatus.CREATED).body(compteMedecinSpecialisteDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la création du compte Medecin Generaliste : " + e.getMessage());
        }
    }

    @PostMapping("/DeMedecin-Assure")
    public ResponseEntity<?> DeMedecinAssure(@Validated @RequestBody MedecinAssureDTO medecinAssureDTO){
        return ResponseEntity.ok(personneService.createNew(medecinAssureDTO));
    }

    @PostMapping("/DeAssure-Generaliste")
    public ResponseEntity<?> DeAssureGeneraliste(@Validated @RequestBody AssureGeneralisteDTO assureGeneralisteDTO){
        return ResponseEntity.ok(personneService.createNew(assureGeneralisteDTO));
    }

    @PostMapping("/DeAssure-Specialite")
    public ResponseEntity<?> DeAssureSpecialite(@Validated @RequestBody AssureSpecialisteDTO assureSpecialisteDTO){
        return ResponseEntity.ok(personneService.createNew(assureSpecialisteDTO));
    }

}
