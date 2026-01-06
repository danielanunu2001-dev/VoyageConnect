package com.voyageconnect.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "avis")
public class Avis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "type_produit", nullable = false)
    private String typeProduit; // VOL, HOTEL, CIRCUIT, DESTINATION

    @Column(name = "id_produit", nullable = false)
    private Long idProduit;

    @Column(nullable = false)
    private int note;

    @Lob
    private String commentaire;

    @Column(name = "date_avis", updatable = false)
    private LocalDateTime dateAvis;

    @PrePersist
    protected void onCreate() {
        dateAvis = LocalDateTime.now();
    }

    // Constructeurs
    public Avis() {}

    public Avis(User user, String typeProduit, Long idProduit, int note, String commentaire) {
        this.user = user;
        this.typeProduit = typeProduit;
        this.idProduit = idProduit;
        this.note = note;
        this.commentaire = commentaire;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTypeProduit() {
        return typeProduit;
    }

    public void setTypeProduit(String typeProduit) {
        this.typeProduit = typeProduit;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public LocalDateTime getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(LocalDateTime dateAvis) {
        this.dateAvis = dateAvis;
    }
}
