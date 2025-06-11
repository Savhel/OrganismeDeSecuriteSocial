package com.fivet.organismedesecuritesocial.Services;


import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.FeuilleMaladieDTO;
import com.fivet.organismedesecuritesocial.Services.DTO.DtoMapper;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.CreationFeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.LectureFeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.ModificationFeuilleMaladie;
import com.fivet.organismedesecuritesocial.Services.FeuilleMaladie.SuppressionFeuilleMaladie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class FeuilleMaladieService {

    @Autowired
    private CreationFeuilleMaladie creationFeuilleMaladie;

    @Autowired
    private LectureFeuilleMaladie lectureFeuilleMaladie;

    @Autowired
    private ModificationFeuilleMaladie modificationFeuilleMaladie;
    @Autowired
    private SuppressionFeuilleMaladie suppressionFeuilleMaladie;


    public FeuilleMaladieDTO creationFeuilleMaladie(FeuilleMaladie feuilleMaladie) {
        return DtoMapper.toFeuilleMaladieDTO(creationFeuilleMaladie.saveFeuilleMaladie(feuilleMaladie));
    }
    public FeuilleMaladieDTO lectureFeuilleMaladie(UUID id) {
        return DtoMapper.toFeuilleMaladieDTO(lectureFeuilleMaladie.lectureFeuilleMaladie(id));
    }
    public FeuilleMaladieDTO modificationFeuilleMaladie( FeuilleMaladie feuilleMaladie, UUID id) {
        return DtoMapper.toFeuilleMaladieDTO(modificationFeuilleMaladie.updateFeuilleMaladie(feuilleMaladie, id));
    }
    public Boolean suppressionFeuilleMaladie(UUID id) {
        return suppressionFeuilleMaladie.deleteFeuilleMaladie(id);
    }

    public List<FeuilleMaladieDTO> lectureFeuilleMaladie() {
        return DtoMapper.toFeuilleMaladieDTOList(lectureFeuilleMaladie.lectureFeuilleMaladie());
    }


}
