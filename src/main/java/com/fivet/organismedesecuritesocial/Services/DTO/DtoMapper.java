package com.fivet.organismedesecuritesocial.Services.DTO;

import com.fivet.organismedesecuritesocial.Models.*;
import com.fivet.organismedesecuritesocial.Services.DTO.Classes.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoMapper {

    public static MedecinLiteDTO toMedecinLiteDTO(Medecin medecin) {
        return new MedecinLiteDTO(medecin.getIdPersonne(), medecin.getPersonne().getNom(), medecin.getPersonne().getPrenom(), medecin.getNumeroRPPS(), medecin.getAdresseCabinet());
    }

    public static AssureDTO toAssureDTO(Assure patient) {
        if(patient.getMedecintraitant() == null){
            return new AssureDTO(patient.getIdPersonne(), patient.getPersonne().getNom(), patient.getPersonne().getPrenom(), null);
        }
        MedecinLiteDTO medecinLite = toMedecinLiteDTO(patient.getMedecintraitant());
        return new AssureDTO(patient.getIdPersonne(), patient.getPersonne().getNom(), patient.getPersonne().getPrenom(), medecinLite);
    }

    public static MedecinDTO toMedecinDTO(Medecin medecin) {
        List<AssureDTO> patientDtos = medecin.getPatients().stream()
                .map(DtoMapper::toAssureDTO)
                .collect(Collectors.toList());
        return new MedecinDTO(medecin.getIdPersonne(), medecin.getPersonne().getNom(), patientDtos);
    }

    public static SpecialisteDTO toSpecialisteDTO(Specialiste specialiste) {
        return new SpecialisteDTO(specialiste.getIdPersonne(), toMedecinDTO(specialiste.getMedecin()), specialiste.getSpecialite(), specialiste.getDomaineIntervention());
    }

    public static GeneralisteDTO toGeneralisteDTO(Generaliste generaliste) {
        return new GeneralisteDTO(generaliste.getIdPersonne(), toMedecinDTO(generaliste.getMedecin()), generaliste.getSecteur());
    }

    public static List<AssureDTO> toAssureDTOList(List<Assure> patients) {
        return patients.stream()
               .map(patient -> toAssureDTO(patient))
               .collect(Collectors.toList());
    }

    public static List<MedecinDTO> toMedecinDTOList(List<Medecin> medecins) {
        return medecins.stream()
               .map(medecin -> toMedecinDTO(medecin))
               .collect(Collectors.toList());
    }

    public static List<GeneralisteDTO> toGeneralisteDTOList(List<Generaliste> generalistes) {
        return generalistes.stream()
              .map(generaliste -> toGeneralisteDTO(generaliste))
              .collect(Collectors.toList());
    }

    public static List<SpecialisteDTO> toSpecialisteDTOList(List<Specialiste> specialistes) {
        return specialistes.stream()
                .map(specialiste -> toSpecialisteDTO(specialiste))
                .collect(Collectors.toList());
    }

    public static List<MedecinLiteDTO> toMedecinLiteDTOList(List<Medecin> medecins) {
        return medecins.stream()
                .map(medecin -> toMedecinLiteDTO(medecin))
                .collect(Collectors.toList());
    }

    public static PrescriptionDTO toPrescriptionDTO(Prescription prescription) {
        return new PrescriptionDTO(prescription.getId(), prescription.getInstructions(), prescription.getMedicament(), prescription.getDosage(), toSpecialisteDTO(prescription.getSpecialiste()));
    }

    public static List<PrescriptionDTO> toPrescriptionDTOList(List<Prescription> prescriptions) {
        return prescriptions.stream().map(prescription -> toPrescriptionDTO(prescription)).collect(Collectors.toList());
    }

    public static ConsultationDTO toConsultationDTO(Consultation consultation) {
        return new ConsultationDTO(consultation.getId(), consultation.getDateConsultation(), consultation.getHeureDeConsultation(), consultation.getDiagnostic(), consultation.getSoins(), consultation.getMotif(), consultation.getPrix(), toMedecinLiteDTO(consultation.getMedecin()), toPrescriptionDTOList(consultation.getPrescriptions()));
    }

    public static List<ConsultationDTO> toConsultationDTOList(List<Consultation> consultations) {
        return consultations.stream().map(consultation -> toConsultationDTO(consultation)).collect(Collectors.toList());
    }

    public static FeuilleMaladieDTO toFeuilleMaladieDTO(FeuilleMaladie feuilleMaladie) {
        return new FeuilleMaladieDTO(feuilleMaladie.getId(),feuilleMaladie.getDateEmission(),feuilleMaladie.getEtatRemborursement(),feuilleMaladie.getTaux(),feuilleMaladie.getModeRemboursement(),feuilleMaladie.getCodeAssurance(),toConsultationDTO(feuilleMaladie.getConsultation()));
    }
    public static List<FeuilleMaladieDTO> toFeuilleMaladieDTOList(List<FeuilleMaladie> feuilleMaladies) {
        return feuilleMaladies.stream().map(feuilleMaladie -> toFeuilleMaladieDTO(feuilleMaladie)).collect(Collectors.toList());
    }

    public static ConsultationLiteDTO toConsultationLiteDTO(Consultation consultation) {
        return new ConsultationLiteDTO(consultation.getId(), consultation.getDateConsultation(), consultation.getHeureDeConsultation(), consultation.getDiagnostic(), consultation.getSoins(), consultation.getMotif(), consultation.getPrix(), toAssureDTO(consultation.getAssure()));
    }

    public static List<ConsultationLiteDTO> toConsultationLiteDTOList(List<Consultation> consultations) {
        return consultations.stream().map(consultation -> toConsultationLiteDTO(consultation)).collect(Collectors.toList());
    }

    public static RemboursementCashDTO toRemboursementCashDTO(RemboursementCash remboursement) {
        return new RemboursementCashDTO(remboursement.getIdRemboursement(),remboursement.getLieuRemboursement(),remboursement.getRemboursement().getDateRemboursement(),toFeuilleMaladieDTO(remboursement.getRemboursement().getFeuilleMaladie()));
    }
    public static List<RemboursementCashDTO> toRemboursementCashDTOList(List<RemboursementCash> remboursements) {
        return remboursements.stream().map(remboursement -> toRemboursementCashDTO(remboursement)).collect(Collectors.toList());
    }

    public static RemboursementVirementDTO toRemboursementVirementDTO(RemboursementVirement remboursement) {
        return new RemboursementVirementDTO(remboursement.getIdRemboursement(),remboursement.getNumeroDeCompte(),remboursement.getNomDeBanque(), remboursement.getRemboursement().getDateRemboursement(),toFeuilleMaladieDTO(remboursement.getRemboursement().getFeuilleMaladie()));
    }

    public static List<RemboursementVirementDTO> toRemboursementVirementDTOList(List<RemboursementVirement> remboursements) {
        return remboursements.stream().map(remboursement -> toRemboursementVirementDTO(remboursement)).collect(Collectors.toList());
    }

}

