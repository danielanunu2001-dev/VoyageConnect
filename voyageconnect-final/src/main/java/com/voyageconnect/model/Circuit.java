package com.voyageconnect.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "circuit")
public class Circuit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Lob
    private String description;

    @Column(nullable = false)
    private int duree; // en jours

    @Column(nullable = false)
    private BigDecimal prix;

    private boolean disponible;

    @ManyToMany
    @JoinTable(
        name = "circuit_destination",
        joinColumns = @JoinColumn(name = "circuit_id"),
        inverseJoinColumns = @JoinColumn(name = "destination_id")
    )
    private Set<Destination> destinations;

    // Constructeurs
    public Circuit() {}

    public Circuit(String nom, String description, int duree, BigDecimal prix, boolean disponible) {
        this.nom = nom;
        this.description = description;
        this.duree = duree;
        this.prix = prix;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(Set<Destination> destinations) {
        this.destinations = destinations;
    }
}
