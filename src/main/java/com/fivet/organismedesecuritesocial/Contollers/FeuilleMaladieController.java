package com.fivet.organismedesecuritesocial.Contollers;

import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladiePdfService;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/feuille-maladie")
@CrossOrigin(origins = "*")
public class FeuilleMaladieController {

    @Autowired
    private FeuilleMaladiePdfService pdfService;

    @Autowired
    private FeuilleMaladieService feuilleMaladieService;

    /**
     * Génère et télécharge le PDF d'une feuille de maladie
     */
    @GetMapping("/{id}/pdf")
    public ResponseEntity<byte[]> generatePdf(@PathVariable UUID id) {
        System.out.println(id);
        try {
            // Récupérer la feuille de maladie avec toutes ses relations
            FeuilleMaladie feuilleMaladie = feuilleMaladieService.findByIdWithDetails(id);

            if (feuilleMaladie == null) {
                return ResponseEntity.notFound().build();
            }

            // Générer le PDF
            byte[] pdfContent = pdfService.generateFeuilleMaladiePdf(feuilleMaladie);

            // Préparer la réponse
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment",
                    "feuille_maladie_" + id.toString().substring(0, 8) + ".pdf");
            headers.setContentLength(pdfContent.length);

            return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Prévisualise le PDF dans le navigateur
     */
    @GetMapping("/{id}/pdf/preview")
    public ResponseEntity<byte[]> previewPdf(@PathVariable UUID id) {
        try {
            FeuilleMaladie feuilleMaladie = feuilleMaladieService.findByIdWithDetails(id);

            if (feuilleMaladie == null) {
                return ResponseEntity.notFound().build();
            }

            byte[] pdfContent = pdfService.generateFeuilleMaladiePdf(feuilleMaladie);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline",
                    "feuille_maladie_" + id.toString().substring(0, 8) + ".pdf");

            return new ResponseEntity<>(pdfContent, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Génère un PDF pour plusieurs feuilles de maladie (batch)
     */
    @PostMapping("/pdf/batch")
    public ResponseEntity<byte[]> generateBatchPdf(@RequestBody java.util.List<UUID> ids) {
        try {
            // TODO: Implémenter la génération batch si nécessaire
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
