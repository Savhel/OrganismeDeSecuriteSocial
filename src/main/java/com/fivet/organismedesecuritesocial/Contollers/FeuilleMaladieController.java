package com.fivet.organismedesecuritesocial.Contollers;


import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/feuilles-maladie")
public class FeuilleMaladieController {

    @Autowired
    private FeuilleMaladieService feuilleMaladieService;

//    @PostMapping("/generer/{consultationId}")
//    public FeuilleMaladie generer(@PathVariable UUID consultationId) {
//        return feuilleMaladieService.creationFeuilleMaladie(consultationId);
//    }


}
