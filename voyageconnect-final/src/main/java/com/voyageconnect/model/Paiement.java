package com.voyageconnect.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paiement")
public class Paiement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id", nullable = false, unique = true)
    private Reservation reservation;

    @Column(nullable = false)
    private BigDecimal montant;

    private String methode; // STRIPE, PAYPAL, SIMULE

    @Column(nullable = false)
    private String statut; // EN_ATTENTE, REUSSI, ECHOUE

    @Column(name = "date_paiement")
    private LocalDateTime datePaiement;

    @Column(name = "facture_pdf_path")
    private String facturePdfPath;

    // Constructeurs
    public Paiement() {}

    public Paiement(Reservation reservation, BigDecimal montant, String methode, String statut, LocalDateTime datePaiement, String facturePdfPath) {
        this.reservation = reservation;
        this.montant = montant;
        this.methode = methode;
        this.statut = statut;
        this.datePaiement = datePaiement;
        this.facturePdfPath = facturePdfPath;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getMethode() {
        return methode;
    }

    public void setMethode(String methode) {
        this.methode = methode;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getFacturePdfPath() {
        return facturePdfPath;
    }

    public void setFacturePdfPath(String facturePdfPath) {
        this.facturePdfPath = facturePdfPath;
    }
}
