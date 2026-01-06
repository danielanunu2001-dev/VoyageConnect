-- Insertion des utilisateurs initiaux
-- Le mot de passe pour les deux utilisateurs est 'admin' (haché avec BCrypt)
INSERT INTO users (nom, prenom, email, password, role, telephone, created_at) VALUES
('Admin', 'Global', 'admin@voyageconnect.com', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', 'ADMIN', '0102030405', CURRENT_TIMESTAMP),
('Client', 'Test', 'client@test.com', '$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6', 'CLIENT', '0607080910', CURRENT_TIMESTAMP);

-- Insertion de destinations de test
INSERT INTO destination (nom, pays, ville, description, image) VALUES
('Tour Eiffel', 'France', 'Paris', 'Symbole emblématique de Paris, offrant une vue panoramique imprenable sur la ville.', 'images/paris.jpg'),
('Mont Fuji', 'Japon', 'Tokyo', 'Volcan majestueux et site de pèlerinage, visible depuis Tokyo par temps clair.', 'images/tokyo.jpg'),
('Statue de la Liberté', 'États-Unis', 'New York', 'Cadeau de la France aux États-Unis, elle accueille les visiteurs à l''entrée du port de New York.', 'images/newyork.jpg'),
('Colisée', 'Italie', 'Rome', 'Le plus grand amphithéâtre jamais construit dans l''Empire romain, témoin de combats de gladiateurs.', 'images/rome.jpg');

-- Insertion de vols de test
INSERT INTO vol (compagnie, aeroport_depart, aeroport_arrivee, date_depart, date_arrivee, prix, places_disponibles) VALUES
('Air France', 'CDG', 'JFK', '2024-10-15 08:00:00+02', '2024-10-15 10:30:00-04', 550.00, 120),
('Japan Airlines', 'HND', 'CDG', '2024-11-20 22:00:00+09', '2024-11-21 04:30:00+01', 850.00, 80),
('Delta Airlines', 'JFK', 'FCO', '2024-09-05 19:00:00-04', '2024-09-06 09:30:00+02', 620.00, 150);

-- Insertion d'hôtels de test
INSERT INTO hotel (nom, ville, adresse, description, prix_par_nuit, disponible) VALUES
('Hôtel Plaza Athénée', 'Paris', '25 Avenue Montaigne, 75008 Paris', 'Palace de luxe avec vue sur la Tour Eiffel.', 980.00, true),
('Park Hyatt Tokyo', 'Tokyo', '3-7-1-2 Nishi-Shinjuku, Shinjuku-Ku, Tokyo', 'Hôtel 5 étoiles célèbre pour ses vues panoramiques et son bar.', 750.00, true),
('The Knickerbocker', 'New York', '6 Times Square, New York, NY 10036', 'Hôtel historique au cœur de Times Square.', 550.00, false);

-- Insertion de circuits de test
INSERT INTO circuit (nom, description, duree, prix, disponible) VALUES
('Merveilles d''Europe', 'Un voyage à travers Paris, Rome et Amsterdam.', 10, 2500.00, true),
('Trésors du Japon', 'Explorez Tokyo, Kyoto et Osaka en 15 jours.', 15, 4500.00, true);

-- Association des destinations aux circuits
INSERT INTO circuit_destination (circuit_id, destination_id) VALUES
(1, 1), -- Merveilles d'Europe -> Tour Eiffel (Paris)
(1, 4), -- Merveilles d'Europe -> Colisée (Rome)
(2, 2); -- Trésors du Japon -> Mont Fuji (Tokyo)

-- Insertion d'une réservation de test pour l'utilisateur client
INSERT INTO reservation (user_id, vol_id, hotel_id, circuit_id, statut, montant_total) VALUES
(2, 1, 1, null, 'CONFIRME', 1530.00); -- Vol + 1 nuit d'hôtel

-- Insertion d'un paiement pour la réservation de test
INSERT INTO paiement (reservation_id, montant, methode, statut, date_paiement) VALUES
(1, 1530.00, 'SIMULE', 'REUSSI', CURRENT_TIMESTAMP);
