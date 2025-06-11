package com.fivet.organismedesecuritesocial.Services.Remboursement;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Remboursement;
import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementCashRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementVirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ModificationRemboursement {

    @Autowired
    private RemboursementRepository remboursementRepository;

    @Autowired
    private RemboursementCashRepository remboursementCashRepository;

    @Autowired
    private RemboursementVirementRepository remboursementVirementRepository;

    @Transactional
    public RemboursementCash modificationRemboursementCash(Remboursement remboursement, RemboursementCash remboursementCash, UUID id) {

        // Vérification et mise à jour du remboursement principal
        Remboursement remboursementExistant = remboursementRepository.findById(id)
                .orElseThrow(() -> new UUIDNotExist("Remboursement introuvable"));

        remboursementExistant.setDateRemboursement(remboursement.getDateRemboursement());
        remboursementExistant.setFeuilleMaladie(remboursement.getFeuilleMaladie());
        remboursementRepository.save(remboursementExistant);

        // Vérification et mise à jour du remboursement cash
        RemboursementCash remboursementCashExistant = remboursementCashRepository.findById(id)
                .orElseThrow(() -> new UUIDNotExist("Remboursement cash introuvable"));

        remboursementCashExistant.setLieuRemboursement(remboursementCash.getLieuRemboursement());
        remboursementCashExistant.setRemboursement(remboursementExistant);

        return remboursementCashRepository.save(remboursementCashExistant);
    }

    @Transactional
    public RemboursementVirement modificationRemboursementCash(Remboursement remboursement, RemboursementVirement remboursementVirement, UUID id) {

        // Vérification et mise à jour du remboursement principal
        Remboursement remboursementExistant = remboursementRepository.findById(id)
                .orElseThrow(() -> new UUIDNotExist("Remboursement introuvable"));

        remboursementExistant.setDateRemboursement(remboursement.getDateRemboursement());
        remboursementExistant.setFeuilleMaladie(remboursement.getFeuilleMaladie());
        remboursementRepository.save(remboursementExistant);

        // Vérification et mise à jour du remboursement cash
        RemboursementVirement remboursementVirementExistant = remboursementVirementRepository.findById(id)
                .orElseThrow(() -> new UUIDNotExist("Remboursement cash introuvable"));

        remboursementVirementExistant.setNomDeBanque(remboursementVirement.getNomDeBanque());
        remboursementVirementExistant.setNumeroDeCompte(remboursementVirement.getNumeroDeCompte());
        remboursementVirementExistant.setRemboursement(remboursementExistant);

        return remboursementVirementRepository.save(remboursementVirementExistant);
    }
}

