package com.fivet.organismedesecuritesocial.Services.Remboursement;

import com.fivet.organismedesecuritesocial.Models.Remboursement;
import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementCashRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementVirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreationRemboursement {
    @Autowired
    private RemboursementRepository remboursementRepository;
    @Autowired
    private RemboursementCashRepository remboursementCashRepository;
    @Autowired
    private RemboursementVirementRepository remboursementVirementRepository;

    public RemboursementCash saveRemboursement(Remboursement remboursement, RemboursementCash remboursementCash) {
        remboursementRepository.save(remboursement);
        return remboursementCashRepository.save(remboursementCash);
    }
    public RemboursementVirement saveRemboursement(Remboursement remboursement, RemboursementVirement remboursementVirement) {
        remboursementRepository.save(remboursement);
        return remboursementVirementRepository.save(remboursementVirement);
    }

}
