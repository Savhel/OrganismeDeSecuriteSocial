package com.fivet.organismedesecuritesocial.Services;

import com.fivet.organismedesecuritesocial.Models.*;
import com.fivet.organismedesecuritesocial.Repositories.MedecinRepository;
import com.fivet.organismedesecuritesocial.Repositories.PersonneRepository;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.*;
import com.fivet.organismedesecuritesocial.Services.DTO.DtoMapper;
import com.fivet.organismedesecuritesocial.Services.Personne.Creation.*;
import com.fivet.organismedesecuritesocial.Services.Personne.Lecture.LectureAssure;
import com.fivet.organismedesecuritesocial.Services.Personne.Lecture.LectureGeneraliste;
import com.fivet.organismedesecuritesocial.Services.Personne.Lecture.LectureSpecialiste;
import com.fivet.organismedesecuritesocial.Services.Personne.Modification.*;
import com.fivet.organismedesecuritesocial.Services.Personne.Suppression.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class PersonneService {

    @Autowired
    private CreatePersonne createPersonne;
    @Autowired
    private CreateAssure createAssure;
    @Autowired
    private CreationMedecin creationMedecin;
    @Autowired
    private CreationMedecinGeneraliste creationMedecinGeneraliste;
    @Autowired
    private CreationSpecialiste creationSpecialiste;
    @Autowired
    private ModifierAssure modifierAssure;
    @Autowired
    private ModifierPersonne modifierPersonne;
    @Autowired
    private ModifierMedecin modifierMedecin;
    @Autowired
    private ModifierGeneraliste modifierGeneraliste;
    @Autowired
    private ModifierSpecialiste modifierSpecialiste;
    @Autowired
    private SuppressionAssure suppressionAssure;
    @Autowired
    private SuppressionPersonne suppressionPersonne;
    @Autowired
    private SuppressionMedecin suppressionMedecin;
    @Autowired
    private SuppressionGeneraliste suppressionGeneraliste;
    @Autowired
    private SuppressionSpecialiste suppressionSpecialiste;
    @Autowired
    private LectureGeneraliste lectureGeneraliste;
    @Autowired
    private LectureAssure lectureAssure;
    @Autowired
    private LectureSpecialiste lectureSpecialiste;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private MedecinRepository medecinRepository;

    @Transactional
    public AssureDTO createNew(Personne personne, Assure assure) {
        assure.setPersonne(createPersonne.createAccount(personne));
        return DtoMapper.toAssureDTO(createAssure.createAccount(assure));
    }

    @Transactional
    public AssureDTO createNew(MedecinAssureDTO medecinAssureDTO) {
        medecinAssureDTO.getAssure().setPersonne(personneRepository.findByIdPersonne(medecinAssureDTO.getIdMedecin()).get());
        return DtoMapper.toAssureDTO(createAssure.createAccount(medecinAssureDTO.getAssure()));
    }

    @Transactional
    public GeneralisteDTO createNew(AssureGeneralisteDTO assureGeneralisteDTO) {
        assureGeneralisteDTO.getMedecin().setPersonne(personneRepository.findByIdPersonne(assureGeneralisteDTO.getIdPersonne()).get());
        assureGeneralisteDTO.getGeneraliste().setMedecin(creationMedecin.createAccount(assureGeneralisteDTO.getMedecin()));
        return DtoMapper.toGeneralisteDTO(creationMedecinGeneraliste.createAccount(assureGeneralisteDTO.getGeneraliste()));
    }

    @Transactional
    public SpecialisteDTO createNew(AssureSpecialisteDTO assureSpecialisteDTO) {
        assureSpecialisteDTO.getMedecin().setPersonne(personneRepository.findByIdPersonne(assureSpecialisteDTO.getIdPersonne()).get());
        assureSpecialisteDTO.getSpecialiste().setMedecin(creationMedecin.createAccount(assureSpecialisteDTO.getMedecin()));
        return DtoMapper.toSpecialisteDTO(creationSpecialiste.createAccount(assureSpecialisteDTO.getSpecialiste()));
    }

    @Transactional
    public GeneralisteDTO createNew(Personne personne, Medecin medecin, Generaliste generaliste){
        medecin.setPersonne(createPersonne.createAccount(personne));
        generaliste.setMedecin(creationMedecin.createAccount(medecin));
        return DtoMapper.toGeneralisteDTO(creationMedecinGeneraliste.createAccount(generaliste));
    }
    @Transactional
    public SpecialisteDTO createNew(Personne personne, Medecin medecin, Specialiste specialiste){
        medecin.setPersonne(createPersonne.createAccount(personne));
        specialiste.setMedecin(creationMedecin.createAccount(medecin));
        return DtoMapper.toSpecialisteDTO(creationSpecialiste.createAccount(specialiste));
    }


    @Transactional
    public AssureDTO updateOld(Personne personne, Assure assure, UUID idPersonne){
        modifierAssure.modifierAccount(assure, idPersonne);
        assure.setPersonne(modifierPersonne.modifierAccount(personne,idPersonne));
        assure.setIdPersonne(idPersonne);
        assure.setMedecintraitant(medecinRepository.findByIdPersonne(assure.getMedecintraitant().getIdPersonne()).get());
        System.out.println(assure);
        return DtoMapper.toAssureDTO(assure);
    }
    @Transactional
    public SpecialisteDTO updateOld(Specialiste specialiste, UUID idPersonne){
        modifierPersonne.modifierAccount(modifierMedecin.modifierAccount(modifierSpecialiste.modifierAccount(specialiste, idPersonne).getMedecin(), idPersonne).getPersonne(),idPersonne);
        return DtoMapper.toSpecialisteDTO(specialiste);
    }
    @Transactional
    public GeneralisteDTO updateOld(Generaliste generaliste, UUID idPersonne){
        modifierPersonne.modifierAccount(modifierMedecin.modifierAccount(modifierGeneraliste.modifierAccount(generaliste, idPersonne).getMedecin(), idPersonne).getPersonne(),idPersonne);
        return DtoMapper.toGeneralisteDTO(generaliste);
    }
    @Transactional
    public Boolean deleteOld(UUID idPersonne, String classe){
        if(classe.equals("assure")){
            suppressionAssure.supprimerAccount(idPersonne);
        } else if (classe.equals("specialiste")) {
            suppressionSpecialiste.supprimerAccount(idPersonne);
            suppressionMedecin.supprimerAccount(idPersonne);
        } else if (classe.equals("generaliste")) {
            suppressionGeneraliste.supprimerAccount(idPersonne);
            suppressionMedecin.supprimerAccount(idPersonne);
        }
        return suppressionPersonne.supprimerAccount(idPersonne);
    }
    @Transactional
    public AssureDTO readOldAssure(UUID idPersonne){
        return DtoMapper.toAssureDTO(lectureAssure.lireAccount(idPersonne));
    }
    @Transactional
    public SpecialisteDTO readOldSpecialiste(UUID idPersonne){
        return DtoMapper.toSpecialisteDTO(lectureSpecialiste.lireAccount(idPersonne));
    }
    @Transactional
    public GeneralisteDTO readOldGeneraliste(UUID idPersonne){
        return DtoMapper.toGeneralisteDTO(lectureGeneraliste.lireAccount(idPersonne));
    }
    @Transactional
    public List<AssureDTO> readOldAssures(){
        return DtoMapper.toAssureDTOList(lectureAssure.lireAccounts());
    }
    @Transactional
    public List<AssureDTO> readOldAssuresParMedecin(UUID idMedecin){
        return DtoMapper.toAssureDTOList(lectureAssure.lireAccounts(idMedecin));
    }
    @Transactional
    public List<SpecialisteDTO> readOldSpecialistes(){
        return DtoMapper.toSpecialisteDTOList(lectureSpecialiste.lireAccounts());
    }
    @Transactional
    public List<GeneralisteDTO> readOldGeneralistes(){
        return DtoMapper.toGeneralisteDTOList(lectureGeneraliste.lireAccounts());
    }

}
