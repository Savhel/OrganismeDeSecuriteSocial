package com.fivet.organismedesecuritesocial.Services.Remboursement;

import com.fivet.organismedesecuritesocial.Exceptions.UUIDNotExist;
import com.fivet.organismedesecuritesocial.Models.Remboursement;
import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import com.fivet.organismedesecuritesocial.Repositories.FeuilleMaladieRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementCashRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementVirementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class CreationRemboursement {
    @Autowired
    private RemboursementRepository remboursementRepository;
    @Autowired
    private RemboursementCashRepository remboursementCashRepository;
    @Autowired
    private RemboursementVirementRepository remboursementVirementRepository;
    @Autowired
    private FeuilleMaladieRepository feuilleMaladieRepository;

    @Transactional
    public RemboursementCash saveRemboursement(RemboursementCash remboursementCash, UUID idFeuilleMaladie) {
        if (feuilleMaladieRepository.findById(idFeuilleMaladie).isPresent()){
            Remboursement remboursement = new Remboursement();
            remboursement.setFeuilleMaladie(feuilleMaladieRepository.findById(idFeuilleMaladie)
                    .map(f -> {
                        f.setEtatRemborursement("remboursé");
                        return feuilleMaladieRepository.save(f);
                    }).get());
            remboursement.setDateRemboursement(LocalDate.now());
            remboursementCash.setRemboursement(remboursementRepository.save(remboursement));

            return remboursementCashRepository.save(remboursementCash);
        }
        throw new UUIDNotExist(" Cette feuille de maladie n'existe pas");
    }

    @Transactional
    public RemboursementVirement saveRemboursement(RemboursementVirement remboursementVirement, UUID idFeuilleMaladie) {

        if (feuilleMaladieRepository.findById(idFeuilleMaladie).isPresent()){
            Remboursement remboursement = new Remboursement();
            remboursement.setFeuilleMaladie(feuilleMaladieRepository.findById(idFeuilleMaladie)
                    .map(f -> {
                        f.setEtatRemborursement("remboursé");
                        return feuilleMaladieRepository.save(f);
                    }).get());
            remboursement.setDateRemboursement(LocalDate.now());
            remboursementVirement.setRemboursement(remboursementRepository.save(remboursement));

            return remboursementVirementRepository.save(remboursementVirement);
        }
        throw new UUIDNotExist(" Cette feuille de maladie n'existe pas");
    }

}
