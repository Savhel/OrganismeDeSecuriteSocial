package com.fivet.organismedesecuritesocial.Services;

import com.fivet.organismedesecuritesocial.Models.Consultation;
import com.fivet.organismedesecuritesocial.Models.FeuilleMaladie;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

@Service
public class FeuilleMaladiePdfService {

    private static final DeviceRgb HEADER_COLOR = new DeviceRgb(41, 128, 185);
    private static final DeviceRgb LIGHT_BLUE = new DeviceRgb(174, 214, 241);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public byte[] generateFeuilleMaladiePdf(FeuilleMaladie feuilleMaladie) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Polices
        PdfFont boldFont = PdfFontFactory.createFont("Helvetica-Bold");
        PdfFont normalFont = PdfFontFactory.createFont("Helvetica");

        // En-tête principal
        addMainHeader(document, boldFont);

        // Informations de la feuille
        addFeuilleInfo(document, feuilleMaladie, boldFont, normalFont);

        // Informations du médecin
        addMedecinInfo(document, feuilleMaladie.getConsultation(), boldFont, normalFont);

        // Informations de l'assuré
        addAssureInfo(document, feuilleMaladie.getConsultation(), boldFont, normalFont);

        // Informations de la consultation
        addConsultationInfo(document, feuilleMaladie.getConsultation(), boldFont, normalFont);

        // Informations de remboursement
        addRemboursementInfo(document, feuilleMaladie, boldFont, normalFont);

        // Pied de page
        addFooter(document, normalFont);

        document.close();
        return baos.toByteArray();
    }

    private void addMainHeader(Document document, PdfFont boldFont) {
        // Titre principal
        Paragraph title = new Paragraph("FEUILLE DE MALADIE")
                .setFont(boldFont)
                .setFontSize(20)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(HEADER_COLOR)
                .setFontColor(ColorConstants.WHITE)
                .setPadding(15)
                .setMarginBottom(20);

        document.add(title);

        // Sous-titre
        Paragraph subtitle = new Paragraph("Prise en charge des frais médicaux")
                .setFont(boldFont)
                .setFontSize(12)
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(20);

        document.add(subtitle);
    }

    private void addFeuilleInfo(Document document, FeuilleMaladie feuilleMaladie, PdfFont boldFont, PdfFont normalFont) {
        Table infoTable = new Table(UnitValue.createPercentArray(new float[]{1, 1}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(15);

        // Numéro de feuille
        infoTable.addCell(createHeaderCell("N° Feuille de Maladie", boldFont));
        infoTable.addCell(createDataCell(feuilleMaladie.getId().toString().substring(0, 8).toUpperCase(), normalFont));

        // Date d'émission
        infoTable.addCell(createHeaderCell("Date d'émission", boldFont));
        infoTable.addCell(createDataCell(feuilleMaladie.getDateEmission().format(DATE_FORMATTER), normalFont));

        // Code assurance
        infoTable.addCell(createHeaderCell("Code Assurance", boldFont));
        infoTable.addCell(createDataCell(feuilleMaladie.getCodeAssurance(), normalFont));

        document.add(infoTable);
    }

    private void addMedecinInfo(Document document, Consultation consultation, PdfFont boldFont, PdfFont normalFont) {
        // Section Médecin
        Paragraph medecinTitle = new Paragraph("INFORMATIONS DU MÉDECIN")
                .setFont(boldFont)
                .setFontSize(14)
                .setBackgroundColor(LIGHT_BLUE)
                .setPadding(8)
                .setMarginTop(15)
                .setMarginBottom(10);

        document.add(medecinTitle);

        Table medecinTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(15);

        if (consultation.getMedecin() != null) {
            medecinTable.addCell(createHeaderCell("Nom", boldFont));
            medecinTable.addCell(createDataCell(consultation.getMedecin().getPersonne().getNom(), normalFont));

            medecinTable.addCell(createHeaderCell("Prénom", boldFont));
            medecinTable.addCell(createDataCell(consultation.getMedecin().getPersonne().getPrenom(), normalFont));

            medecinTable.addCell(createHeaderCell("Identifiant", boldFont));
            medecinTable.addCell(createDataCell(consultation.getMedecin().getNumeroRPPS(), normalFont));

            medecinTable.addCell(createHeaderCell("Adresse du Cabinet", boldFont));
            medecinTable.addCell(createDataCell(consultation.getMedecin().getAdresseCabinet(), normalFont));

            medecinTable.addCell(createHeaderCell("Téléphone", boldFont));
            medecinTable.addCell(createDataCell(consultation.getMedecin().getPersonne().getTelephone(), normalFont));
        }

        document.add(medecinTable);
    }

    private void addAssureInfo(Document document, Consultation consultation, PdfFont boldFont, PdfFont normalFont) {
        // Section Assuré
        Paragraph assureTitle = new Paragraph("INFORMATIONS DE L'ASSURÉ")
                .setFont(boldFont)
                .setFontSize(14)
                .setBackgroundColor(LIGHT_BLUE)
                .setPadding(8)
                .setMarginTop(15)
                .setMarginBottom(10);

        document.add(assureTitle);

        Table assureTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(15);

        if (consultation.getAssure() != null) {
            assureTable.addCell(createHeaderCell("Nom", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getNom(), normalFont));

            assureTable.addCell(createHeaderCell("Prénom", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getPrenom(), normalFont));

            assureTable.addCell(createHeaderCell("N° Assuré", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getTelephone(), normalFont));

            assureTable.addCell(createHeaderCell("Date de naissance", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getDateNaiss().format(DATE_FORMATTER), normalFont));

            assureTable.addCell(createHeaderCell("Lieu de naissance", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getLieuNaiss(), normalFont));

            assureTable.addCell(createHeaderCell("Numero de Sécurité sociale", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getNumeroSecuriteSociale(), normalFont));

            assureTable.addCell(createHeaderCell("Addresse", boldFont));
            assureTable.addCell(createDataCell(consultation.getAssure().getPersonne().getAdresse(), normalFont));
        }

        document.add(assureTable);
    }

    private void addConsultationInfo(Document document, Consultation consultation, PdfFont boldFont, PdfFont normalFont) {
        // Section Consultation
        Paragraph consultationTitle = new Paragraph("DÉTAILS DE LA CONSULTATION")
                .setFont(boldFont)
                .setFontSize(14)
                .setBackgroundColor(LIGHT_BLUE)
                .setPadding(8)
                .setMarginTop(15)
                .setMarginBottom(10);

        document.add(consultationTitle);

        Table consultationTable = new Table(UnitValue.createPercentArray(new float[]{1, 2}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(15);

        consultationTable.addCell(createHeaderCell("Date", boldFont));
        consultationTable.addCell(createDataCell(consultation.getDateConsultation().format(DATE_FORMATTER), normalFont));

        consultationTable.addCell(createHeaderCell("Heure", boldFont));
        consultationTable.addCell(createDataCell(consultation.getHeureDeConsultation().format(TIME_FORMATTER), normalFont));

        consultationTable.addCell(createHeaderCell("Motif", boldFont));
        consultationTable.addCell(createDataCell(consultation.getMotif(), normalFont));

        consultationTable.addCell(createHeaderCell("Diagnostic", boldFont));
        consultationTable.addCell(createDataCell(consultation.getDiagnostic(), normalFont));

        consultationTable.addCell(createHeaderCell("Soins", boldFont));
        consultationTable.addCell(createDataCell(consultation.getSoins(), normalFont));

        consultationTable.addCell(createHeaderCell("Prix (FCFA)", boldFont));
        consultationTable.addCell(createDataCell(String.format("%,d", consultation.getPrix()), normalFont));

        document.add(consultationTable);
    }

    private void addRemboursementInfo(Document document, FeuilleMaladie feuilleMaladie, PdfFont boldFont, PdfFont normalFont) {
        // Section Remboursement
        Paragraph remboursementTitle = new Paragraph("INFORMATIONS DE REMBOURSEMENT")
                .setFont(boldFont)
                .setFontSize(14)
                .setBackgroundColor(HEADER_COLOR)
                .setFontColor(ColorConstants.WHITE)
                .setPadding(8)
                .setMarginTop(15)
                .setMarginBottom(10);

        document.add(remboursementTitle);

        Table remboursementTable = new Table(UnitValue.createPercentArray(new float[]{1, 1, 1}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(20);

        // En-têtes
        remboursementTable.addCell(createHeaderCell("État", boldFont));
        remboursementTable.addCell(createHeaderCell("Taux (%)", boldFont));
        remboursementTable.addCell(createHeaderCell("Mode", boldFont));

        // Données
        remboursementTable.addCell(createDataCell(feuilleMaladie.getEtatRemborursement(), normalFont));
        remboursementTable.addCell(createDataCell(feuilleMaladie.getTaux().toString(), normalFont));
        remboursementTable.addCell(createDataCell(feuilleMaladie.getModeRemboursement(), normalFont));

        document.add(remboursementTable);

        // Calcul du montant remboursable
        Long prixConsultation = feuilleMaladie.getConsultation().getPrix();
        Long montantRembourse = (prixConsultation * feuilleMaladie.getTaux()) / 100;

        Table calculTable = new Table(UnitValue.createPercentArray(new float[]{2, 1}))
                .setWidth(UnitValue.createPercentValue(100))
                .setMarginBottom(20);

        calculTable.addCell(createHeaderCell("Montant total consultation", boldFont));
        calculTable.addCell(createDataCell(String.format("%,d FCFA", prixConsultation), normalFont));

        calculTable.addCell(createHeaderCell("Montant remboursé", boldFont));
        calculTable.addCell(createDataCell(String.format("%,d FCFA", montantRembourse), normalFont)
                .setBackgroundColor(LIGHT_BLUE));

        document.add(calculTable);
    }

    private void addFooter(Document document, PdfFont normalFont) {
        // Pied de page
        Paragraph footer = new Paragraph()
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginTop(30)
                .setBorder(new SolidBorder(ColorConstants.GRAY, 1))
                .setBorderTop(Border.NO_BORDER)
                .setBorderLeft(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setPaddingTop(15);

        footer.add(new Text("Nous vous souhaitons une excelente guérison !\n").setFont(normalFont).setFontSize(10));
        footer.add(new Text("Système de Gestion D'un Organisme De securité sociale").setFont(normalFont).setFontSize(8).setFontColor(ColorConstants.GRAY));

        document.add(footer);
    }

    private Cell createHeaderCell(String content, PdfFont font) {
        return new Cell()
                .add(new Paragraph(content))
                .setFont(font)
                .setFontSize(11)
                .setBackgroundColor(new DeviceRgb(240, 240, 240))
                .setPadding(8)
                .setBorder(new SolidBorder(ColorConstants.GRAY, 0.5f));
    }

    private Cell createDataCell(String content, PdfFont font) {
        return new Cell()
                .add(new Paragraph(content != null ? content : ""))
                .setFont(font)
                .setFontSize(10)
                .setPadding(8)
                .setBorder(new SolidBorder(ColorConstants.LIGHT_GRAY, 0.5f));
    }
}