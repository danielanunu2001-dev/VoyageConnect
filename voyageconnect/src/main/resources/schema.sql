-- Supprime les tables existantes pour une réinitialisation propre
DROP TABLE IF EXISTS notification, avis, paiement, reservation, circuit_destination, circuit, hotel, vol, destination, users CASCADE;

-- Table des utilisateurs
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL CHECK (role IN ('CLIENT', 'ADMIN')),
    telephone VARCHAR(20),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Table des destinations
CREATE TABLE destination (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    pays VARCHAR(255) NOT NULL,
    ville VARCHAR(255) NOT NULL,
    description TEXT,
    image VARCHAR(255)
);

-- Table des vols
CREATE TABLE vol (
    id BIGSERIAL PRIMARY KEY,
    compagnie VARCHAR(255) NOT NULL,
    aeroport_depart VARCHAR(255) NOT NULL,
    aeroport_arrivee VARCHAR(255) NOT NULL,
    date_depart TIMESTAMP WITH TIME ZONE NOT NULL,
    date_arrivee TIMESTAMP WITH TIME ZONE NOT NULL,
    prix DECIMAL(10, 2) NOT NULL,
    places_disponibles INT NOT NULL
);

-- Table des hôtels
CREATE TABLE hotel (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    ville VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    description TEXT,
    prix_par_nuit DECIMAL(10, 2) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

-- Table des circuits
CREATE TABLE circuit (
    id BIGSERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT,
    duree INT NOT NULL, -- en jours
    prix DECIMAL(10, 2) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

-- Table de jointure pour la relation ManyToMany entre Circuit et Destination
CREATE TABLE circuit_destination (
    circuit_id BIGINT NOT NULL,
    destination_id BIGINT NOT NULL,
    PRIMARY KEY (circuit_id, destination_id),
    FOREIGN KEY (circuit_id) REFERENCES circuit(id) ON DELETE CASCADE,
    FOREIGN KEY (destination_id) REFERENCES destination(id) ON DELETE CASCADE
);

-- Table des réservations
CREATE TABLE reservation (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    -- Champs pour la relation polymorphique (un seul sera non-nul par ligne)
    vol_id BIGINT,
    hotel_id BIGINT,
    circuit_id BIGINT,
    date_reservation TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    statut VARCHAR(50) NOT NULL CHECK (statut IN ('EN_COURS', 'CONFIRME', 'ANNULE')),
    montant_total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (vol_id) REFERENCES vol(id) ON DELETE SET NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotel(id) ON DELETE SET NULL,
    FOREIGN KEY (circuit_id) REFERENCES circuit(id) ON DELETE SET NULL
);

-- Table des paiements (relation OneToOne avec Réservation)
CREATE TABLE paiement (
    id BIGSERIAL PRIMARY KEY,
    reservation_id BIGINT UNIQUE NOT NULL,
    montant DECIMAL(10, 2) NOT NULL,
    methode VARCHAR(50) CHECK (methode IN ('STRIPE', 'PAYPAL', 'SIMULE')),
    statut VARCHAR(50) NOT NULL CHECK (statut IN ('EN_ATTENTE', 'REUSSI', 'ECHOUE')),
    date_paiement TIMESTAMP WITH TIME ZONE,
    facture_pdf_path VARCHAR(255), -- Chemin vers le fichier PDF généré
    FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE
);

-- Table des avis
CREATE TABLE avis (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    type_produit VARCHAR(50) NOT NULL CHECK (type_produit IN ('VOL', 'HOTEL', 'CIRCUIT', 'DESTINATION')),
    id_produit BIGINT NOT NULL,
    note INT NOT NULL CHECK (note >= 1 AND note <= 5),
    commentaire TEXT,
    date_avis TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Table des notifications
CREATE TABLE notification (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    message TEXT NOT NULL,
    type VARCHAR(50) NOT NULL CHECK (type IN ('EMAIL', 'SMS')),
    date_envoi TIMESTAMP WITH TIME ZONE,
    lu BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Index pour améliorer les performances des recherches
CREATE INDEX idx_user_email ON users(email);
CREATE INDEX idx_destination_pays_ville ON destination(pays, ville);
CREATE INDEX idx_reservation_user ON reservation(user_id);
CREATE INDEX idx_avis_produit ON avis(type_produit, id_produit);
