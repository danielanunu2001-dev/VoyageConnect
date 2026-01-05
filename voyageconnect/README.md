# ✈️ VoyageConnect

> Votre passerelle vers des aventures inoubliables.

**VoyageConnect** est une plateforme web complète et fonctionnelle d'agence de voyage en ligne. Conçu dans un souci de robustesse, de sécurité et de maintenabilité, ce projet met en œuvre une architecture MVC stricte en s'appuyant sur une stack technique Java EE classique, sans Spring Boot.

L'objectif est de démontrer la maîtrise des technologies fondamentales de l'écosystème Java pour le web, tout en fournissant une application prête à être déployée, capable de gérer des utilisateurs, des produits de voyage (vols, hôtels, circuits) et un processus de réservation simulé de bout en bout.

---

## 🔧 Stack Technique

Ce projet a été construit sans aucun framework de haut niveau comme Spring Boot pour se concentrer sur la configuration et l'intégration manuelles des composants fondamentaux.

### Backend
- **Langage** : Java 11
- **Frameworks** :
  - **Spring Framework (5.3)** : Cœur de l'application pour l'injection de dépendances (IoC), la programmation orientée aspect (AOP) et la gestion des transactions (TX).
  - **Spring Security (5.8)** : Gestion de l'authentification et des autorisations.
  - **Java EE** : Servlets (API 5.0) et JavaServer Pages (JSP 3.1) pour le routage et le rendu des vues.
- **Accès aux données** :
  - **Hibernate (5.6)** : Implémentation de référence pour JPA (Java Persistence API) pour le mapping objet-relationnel (ORM).
- **Utilitaires** :
  - **JavaMail (2.0)** : Envoi de notifications par email.
  - **iText (7.2)** : Génération de documents PDF (factures).
  - **SLF4J + Logback** : Journalisation des événements de l'application.

### Frontend
- **Structure** : HTML5 pur
- **Style** : CSS3 pur et **Bootstrap 5** pour un design responsive.
- **Interactivité** : JavaScript natif (vanilla JS) pour les appels AJAX et la manipulation dynamique du DOM.
- **Contrainte** : Aucun framework JavaScript (React, Vue, Angular) n'est utilisé.

### Base de Données
- **SGBDR** : PostgreSQL (Dialecte `PostgreSQL10Dialect`).
- **Pooling de connexions** : C3P0.

### Build & Déploiement
- **Gestion de projet** : Apache Maven
- **Serveur d'application** : Conçu pour être déployé sur Apache Tomcat 10 ou WildFly 30.

### Tests
- **Tests unitaires** : JUnit 5
- **Mocks** : Mockito 5

---

## 🏛️ Architecture Logicielle

Le projet suit une architecture en couches basée sur le design pattern **Modèle-Vue-Contrôleur (MVC)** pour assurer une séparation claire des préoccupations.

```
com.voyageconnect/
├── controller/  // Couche Contrôleur (Servlets)
├── service/     // Couche Métier (Logique applicative)
├── dao/         // Couche d'Accès aux Données (JPA/Hibernate)
├── model/       // Couche Modèle (Entités JPA)
├── security/    // Configuration de la sécurité
├── config/      // Configuration Spring
└── util/        // Classes utilitaires
```

- **`controller` (Contrôleur)** : Contient les Servlets Java. Chaque servlet agit comme un contrôleur qui reçoit les requêtes HTTP, interagit avec la couche `service` pour traiter les demandes, puis sélectionne la vue (JSP) appropriée pour renvoyer la réponse au client.

- **`service` (Couche Métier)** : Contient la logique métier de l'application. C'est ici que sont définies les transactions (`@Transactional`). Les services coordonnent les appels aux différents DAO pour accomplir une fonctionnalité complète (par exemple, "créer une réservation et mettre à jour les disponibilités").

- **`dao` (Data Access Object)** : Contient les interfaces et les implémentations pour l'accès aux données. Cette couche est responsable de toutes les interactions avec la base de données via l'EntityManager de JPA. Elle isole le reste de l'application des détails de la persistance.

- **`model` (Modèle)** : Contient les entités JPA, qui sont des classes Java simples (POJOs) annotées pour être mappées à des tables de la base de données. Elles représentent l'état et la structure des données de l'application.

---

## 🚀 Prise en Main et Démarrage

Suivez ces étapes pour configurer et lancer le projet sur votre machine locale.

### 1. Prérequis
Assurez-vous d'avoir les outils suivants installés :
- **JDK 11** ou supérieur.
- **Apache Maven 3.6** ou supérieur.
- **PostgreSQL 12** ou supérieur.
- Un serveur d'applications comme **Apache Tomcat 10**.

### 2. Configuration de la Base de Données
Le projet est configuré pour se connecter à une base de données PostgreSQL.

1.  **Créez la base de données** via `psql` ou un client SQL :
    ```sql
    CREATE DATABASE voyageconnect;
    ```

2.  **Créez un utilisateur dédié** (recommandé) :
    ```sql
    CREATE USER user WITH PASSWORD 'password';
    GRANT ALL PRIVILEGES ON DATABASE voyageconnect TO user;
    ```
    *Note : Si vous utilisez des identifiants différents, mettez à jour le fichier de configuration à l'étape suivante.*

### 3. Configuration de l'Application
Les informations de connexion à la base de données sont externalisées.

1.  Naviguez vers `src/main/resources/`.
2.  Le fichier `application.properties` contient les informations de connexion par défaut :
    ```properties
    db.driver=org.postgresql.Driver
    db.url=jdbc:postgresql://localhost:5432/voyageconnect
    db.username=user
    db.password=password
    ```
3.  Modifiez ce fichier si vos identifiants PostgreSQL sont différents.

### 4. Peuplement de la Base de Données
Le projet est fourni avec deux scripts SQL pour initialiser la base de données :
- `schema.sql` : Crée toutes les tables et les relations.
- `data.sql` : Insère des données de test (un admin, un client, des destinations, etc.).

Hibernate est configuré avec `hbm2ddl.auto = update`, ce qui signifie qu'il créera ou mettra à jour le schéma automatiquement au premier démarrage. Cependant, pour un contrôle total, il est recommandé d'exécuter manuellement ces scripts via un client SQL sur la base `voyageconnect` avant de lancer l'application.

---

## 📦 Build et Déploiement

### 1. Compiler le Projet
Le projet est packagé sous forme d'un fichier **WAR** (Web Application Archive) à l'aide de Maven.

1.  Ouvrez un terminal à la racine du projet (`voyageconnect/`).
2.  Lancez la commande de build Maven :
    ```bash
    mvn clean package
    ```
3.  Une fois le build terminé avec succès, vous trouverez l'artefact `voyageconnect.war` dans le répertoire `target/`.

### 2. Déployer sur Tomcat
1.  **Démarrez votre serveur Apache Tomcat 10.**
2.  **Copiez** le fichier `target/voyageconnect.war`.
3.  **Collez-le** dans le répertoire `webapps/` de votre installation Tomcat.
4.  Tomcat détectera automatiquement le nouveau fichier WAR et déploiera l'application.
5.  L'application sera accessible à l'URL suivante : `http://localhost:8080/voyageconnect/`

Les logs de l'application seront visibles dans le fichier `logs/catalina.out` de Tomcat, ce qui est utile pour le débogage.

---

## ✨ Fonctionnalités Clés

Voici un aperçu des fonctionnalités principales du projet, organisées par module.

### Gestion des Utilisateurs (MVP V1)
- ✅ Inscription et connexion des utilisateurs.
- ✅ Gestion des rôles `CLIENT` et `ADMIN` avec Spring Security.
- 🚧 Espace profil client avec historique des réservations.

### Catalogue et Recherche
- ✅ Consultation des destinations.
- ✅ Recherche simple par critère.
- 🚧 Recherche multicritère dynamique avec AJAX.
- 🚧 Affichage détaillé des produits (vols, hôtels, circuits).

### Réservation et Paiement
- 🚧 Processus de réservation en plusieurs étapes.
- ✅ Simulation de paiement avec confirmation.
- ✅ Génération de facture au format PDF.
- 🚧 Intégration des API sandbox Stripe / PayPal.

### Espace Administration
- ✅ CRUD complet pour la gestion des destinations.
- 🚧 Dashboard avec statistiques de base.
- 🚧 CRUD pour les vols, hôtels et circuits.

### Notifications
- 🚧 Envoi d'email de confirmation de réservation.
- 🚧 Tâche planifiée pour les rappels de départ.
