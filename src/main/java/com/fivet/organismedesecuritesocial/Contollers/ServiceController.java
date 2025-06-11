package com.fivet.organismedesecuritesocial.Contollers;


import com.fivet.organismedesecuritesocial.Services.DTO.Classes.ChoisirMedecinTraitantDTO;
import com.fivet.organismedesecuritesocial.Services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personne")
public class ServiceController {

    @Autowired
    private PersonneService personneService;

    @PostMapping("choisirMedecinTraitant")
    public ResponseEntity<?> choisirMedecinTraitant(@Validated @RequestBody ChoisirMedecinTraitantDTO choisirMedecinTraitantDTO) {
        return ResponseEntity.ok(personneService.updateOld(choisirMedecinTraitantDTO.getPersonne(),choisirMedecinTraitantDTO.getAssure(),choisirMedecinTraitantDTO.getIdPersonne()));
    }
}
