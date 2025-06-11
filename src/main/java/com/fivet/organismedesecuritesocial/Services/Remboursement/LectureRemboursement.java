package com.fivet.organismedesecuritesocial.Services.Remboursement;

import com.fivet.organismedesecuritesocial.Models.Remboursement;
import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementCashRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementRepository;
import com.fivet.organismedesecuritesocial.Repositories.RemboursementVirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LectureRemboursement {


    @Autowired
    private RemboursementCashRepository remboursementCashRepository;
    @Autowired
    private RemboursementVirementRepository remboursementVirementRepository;

    public RemboursementCash lectureRemboursementCash(UUID id) {
        return remboursementCashRepository.findById(id).get();
    }
    public RemboursementVirement lectureRemboursementVirement(UUID id) {
        return remboursementVirementRepository.findById(id).get();
    }

    public List<RemboursementCash> lectureRemboursementCash() {
        return remboursementCashRepository.findAll();
    }
    public List<RemboursementVirement> lectureRemboursementVirement() {
        return remboursementVirementRepository.findAll();
    }

}
