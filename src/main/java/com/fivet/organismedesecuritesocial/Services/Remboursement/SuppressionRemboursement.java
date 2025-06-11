package com.fivet.organismedesecuritesocial.Services.Remboursement;

import com.fivet.organismedesecuritesocial.Repositories.RemboursementCashRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementVirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SuppressionRemboursement {

    @Autowired
    private RemboursementCashRepository remboursementCashRepository;
    @Autowired
    private RemboursementVirementRepository remboursementVirementRepository;
    @Autowired
    private RemboursementRepository remboursementRepository;

    @Transactional
    public Boolean suppressionRemboursementVirement(UUID id) {
        remboursementVirementRepository.deleteById(id);
        remboursementRepository.deleteById(id);
        return true;
    }
    @Transactional
    public Boolean suppressionRemboursementCash(UUID id) {
        remboursementCashRepository.deleteById(id);
        remboursementRepository.deleteById(id);
        return true;
    }


}
