package com.voyageconnect.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vol")
public class Vol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String compagnie;

    @Column(name = "aeroport_depart", nullable = false)
    private String aeroportDepart;

    @Column(name = "aeroport_arrivee", nullable = false)
    private String aeroportArrivee;

    @Column(name = "date_depart", nullable = false)
    private LocalDateTime dateDepart;

    @Column(name = "date_arrivee", nullable = false)
    private LocalDateTime dateArrivee;

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(name = "places_disponibles", nullable = false)
    private int placesDisponibles;

    // Constructeurs
    public Vol() {}

    public Vol(String compagnie, String aeroportDepart, String aeroportArrivee, LocalDateTime dateDepart, LocalDateTime dateArrivee, BigDecimal prix, int placesDisponibles) {
        this.compagnie = compagnie;
        this.aeroportDepart = aeroportDepart;
        this.aeroportArrivee = aeroportArrivee;
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.prix = prix;
        this.placesDisponibles = placesDisponibles;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public String getAeroportDepart() {
        return aeroportDepart;
    }

    public void setAeroportDepart(String aeroportDepart) {
        this.aeroportDepart = aeroportDepart;
    }

    public String getAeroportArrivee() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(String aeroportArrivee) {
        this.aeroportArrivee = aeroportArrivee;
    }

    public LocalDateTime getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public LocalDateTime getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(LocalDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public int getPlacesDisponibles() {
        return placesDisponibles;
    }

    public void setPlacesDisponibles(int placesDisponibles) {
        this.placesDisponibles = placesDisponibles;
    }
}
