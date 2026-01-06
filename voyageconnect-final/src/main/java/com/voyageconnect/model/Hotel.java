package com.voyageconnect.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String adresse;

    @Lob
    private String description;

    @Column(name = "prix_par_nuit", nullable = false)
    private BigDecimal prixParNuit;

    private boolean disponible;

    // Constructeurs
    public Hotel() {}

    public Hotel(String nom, String ville, String adresse, String description, BigDecimal prixParNuit, boolean disponible) {
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.description = description;
        this.prixParNuit = prixParNuit;
        this.disponible = disponible;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(BigDecimal prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
