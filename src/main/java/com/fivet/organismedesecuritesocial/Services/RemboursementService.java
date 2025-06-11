package com.fivet.organismedesecuritesocial.Services;

import com.fivet.organismedesecuritesocial.Models.Remboursement;
import com.fivet.organismedesecuritesocial.Models.RemboursementCash;
import com.fivet.organismedesecuritesocial.Models.RemboursementVirement;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.RemboursementCashDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.RemboursementVirementDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.DtoMapper;
import com.fivet.organismedesecuritesocial.Services.Remboursement.CreationRemboursement;
import com.fivet.organismedesecuritesocial.Services.Remboursement.LectureRemboursement;
import com.fivet.organismedesecuritesocial.Services.Remboursement.ModificationRemboursement;
import com.fivet.organismedesecuritesocial.Services.Remboursement.SuppressionRemboursement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RemboursementService {

    @Autowired
    private CreationRemboursement creationRemboursement;
    @Autowired
    private LectureRemboursement lectureRemboursement;
    @Autowired
    private ModificationRemboursement modificationRemboursement;
    @Autowired
    private SuppressionRemboursement suppressionRemboursement;

    public RemboursementCashDTO ajouterRembousementCash(Remboursement remboursement, RemboursementCash remboursementCash) {
        return DtoMapper.toRemboursementCashDTO(creationRemboursement.saveRemboursement(remboursement, remboursementCash));
    }
    public RemboursementVirementDTO ajouterRembousementCash(Remboursement remboursement, RemboursementVirement remboursementVirement) {
        return DtoMapper.toRemboursementVirementDTO(creationRemboursement.saveRemboursement(remboursement, remboursementVirement));
    }

    public RemboursementCashDTO modifierRembousementCash(Remboursement remboursement,RemboursementCash remboursementCash, UUID id) {
        return DtoMapper.toRemboursementCashDTO(modificationRemboursement.modificationRemboursementCash(remboursement, remboursementCash, id));
    }

    public RemboursementVirementDTO modifierRembousementCash(Remboursement remboursement,RemboursementVirement remboursementVirement, UUID id) {
        return DtoMapper.toRemboursementVirementDTO(modificationRemboursement.modificationRemboursementCash(remboursement, remboursementVirement, id));
    }

    public Boolean supprimerRembousementCash(UUID id) {
        return suppressionRemboursement.suppressionRemboursementCash(id);
    }

    public Boolean supprimerRembousementVirement(UUID id) {
        return suppressionRemboursement.suppressionRemboursementVirement(id);
    }

    public RemboursementCashDTO lectureRemboursementCash(UUID id) {
        return DtoMapper.toRemboursementCashDTO(lectureRemboursement.lectureRemboursementCash(id));
    }
    public RemboursementVirementDTO lectureRemboursementVirement(UUID id) {
        return DtoMapper.toRemboursementVirementDTO(lectureRemboursement.lectureRemboursementVirement(id));
    }

    public List<RemboursementCashDTO> lectureRemboursementCash() {
        return DtoMapper.toRemboursementCashDTOList(lectureRemboursement.lectureRemboursementCash());
    }

    public List<RemboursementVirementDTO> lectureRemboursementVirement() {
        return DtoMapper.toRemboursementVirementDTOList(lectureRemboursement.lectureRemboursementVirement());
    }


}
