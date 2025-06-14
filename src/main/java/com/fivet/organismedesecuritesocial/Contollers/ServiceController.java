package com.fivet.organismedesecuritesocial.Contollers;


import com.fivet.organismedesecuritesocial.Models.Personne;
import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import com.fivet.organismedesecuritesocial.Services.ConsultationService;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.*;
import com.fivet.organismedesecuritesocial.Services.PersonneService;
import com.fivet.organismedesecuritesocial.Services.RemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/personne")
public class ServiceController {

    @Autowired
    private PersonneService personneService;
    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private RemboursementService remboursementService;

    @PostMapping("choisirMedecinTraitant")
    public ResponseEntity<?> choisirMedecinTraitant(@Validated @RequestBody ChoisirMedecinTraitantDTO choisirMedecinTraitantDTO) {
        System.out.println(choisirMedecinTraitantDTO);
        return ResponseEntity.ok(personneService.updateOld(choisirMedecinTraitantDTO.getPersonne(),choisirMedecinTraitantDTO.getAssure(),choisirMedecinTraitantDTO.getIdPersonne()));
    }

    @PostMapping("/Consulter")
    public ResponseEntity<?> consulter(@Validated @RequestBody ConsulterDTO consulterDTO) {
        System.out.println(consulterDTO);
        return ResponseEntity.ok(consultationService.creerConsultation(consulterDTO));
    }

    @GetMapping("/getAllSpecialiste")
    public ResponseEntity<?> getAllSpecialiste() {
        return ResponseEntity.ok(personneService.readOldSpecialistes());
    }

    @GetMapping("/getAllAssure")
    public ResponseEntity<?> getAllAssure() {
        return ResponseEntity.ok(personneService.readOldAssures());
    }

    @GetMapping("/getAllGeneraliste")
    public ResponseEntity<?> getAllGeneraliste() {
        return ResponseEntity.ok(personneService.readOldGeneralistes());
    }

    @PostMapping("/modifierConsultation")
    public ResponseEntity<?> modifierConsultation(@Validated @RequestBody ModifierConsultationDTO consultationDTO){
        return ResponseEntity.ok(consultationService.modifierConsultation(consultationDTO));
    }

    @GetMapping("/getConsultationByAssure/{id}")
    public ResponseEntity<?> getConsultationByAssure(@PathVariable UUID id){
        return ResponseEntity.ok(consultationService.lectureConsultationParAssure(id));
    }

    @GetMapping("/getConsultationByMedecin/{id}")
    public ResponseEntity<?> getConsultationByMedecin(@PathVariable UUID id){
        return ResponseEntity.ok(consultationService.lectureConsultationParMedecin(id));
    }

    @PostMapping("/remboursementCash")
    public ResponseEntity<?> remboursementCash(@Validated @RequestBody RemboursementDTOCash remboursementCash){
        return ResponseEntity.ok(remboursementService.ajouterRembousementCash(remboursementCash.getRemboursementCash(), remboursementCash.getIdFeuilleMaladie()));
    }

    @PostMapping("/remboursementVirement")
    public ResponseEntity<?> remboursementVirement(@Validated @RequestBody RemboursementDTOVirement remboursementDTOVirement){
        return ResponseEntity.ok(remboursementService.ajouterRembousementCash(remboursementDTOVirement.getRemboursementVirement(), remboursementDTOVirement.getIdFeuilleMaladie()));
    }

}
