package com.voyageconnect.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "destination")
public class Destination implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String pays;

    @Column(nullable = false)
    private String ville;

    @Lob
    private String description;

    private String image;

    @ManyToMany(mappedBy = "destinations")
    private Set<Circuit> circuits;

    // Constructeurs
    public Destination() {}

    public Destination(String nom, String pays, String ville, String description, String image) {
        this.nom = nom;
        this.pays = pays;
        this.ville = ville;
        this.description = description;
        this.image = image;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Circuit> getCircuits() {
        return circuits;
    }

    public void setCircuits(Set<Circuit> circuits) {
        this.circuits = circuits;
    }
}
