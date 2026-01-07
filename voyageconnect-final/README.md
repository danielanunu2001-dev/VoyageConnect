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
  - **Java EE (API `javax`)** : Servlets (API 4.0) et JavaServer Pages (JSP 2.3) pour le routage et le rendu des vues.
- **Accès aux données** :
  - **Hibernate (5.6)** : Implémentation de référence pour JPA (`javax.persistence`) pour le mapping objet-relationnel (ORM).
- **Utilitaires** :
  - **JavaMail (2.0)** : Envoi de notifications par email.
  - **iText (7.2)** : Génération de documents PDF (factures).
  - **SLF4J + Logback** : Journalisation des événements de l'application.

### Frontend
- **Structure** : HTML5 pur
- **Style** : CSS3 pur et **Bootstrap 5** pour un design responsive.
- **Interactivité** : JavaScript natif (vanilla JS).

### Base de Données
- **SGBDR** : PostgreSQL.
- **Pooling de connexions** : C3P0.

### Build & Déploiement
- **Gestion de projet** : Apache Maven
- **Serveur d'application recommandé** : **Apache Tomcat 9** ou tout autre serveur compatible avec `javax.servlet`.
- **Développement local** : Plugin Maven Jetty 9.

### Tests
- **Tests unitaires** : JUnit 5
- **Mocks** : Mockito 5

---

## 🏛️ Architecture Logicielle

Le projet suit une architecture en couches basée sur le design pattern **Modèle-Vue-Contrôleur (MVC)** pour assurer une séparation claire des préoccupations.

- **`controller` (Contrôleur)** : Contient les Servlets, qui gèrent les requêtes HTTP et coordonnent les réponses.
- **`service` (Couche Métier)** : Contient la logique métier et la gestion des transactions.
- **`dao` (Data Access Object)** : Responsable de l'accès aux données via JPA/Hibernate.
- **`model` (Modèle)** : Contient les entités JPA (`javax.persistence`) qui représentent les données.

---

## 🚀 Prise en Main et Démarrage

Suivez ces étapes pour configurer et lancer le projet sur votre machine locale.

### 1. Prérequis
- **JDK 11** ou supérieur.
- **Apache Maven 3.6** ou supérieur.
- **PostgreSQL 12** ou supérieur.

### 2. Configuration de la Base de Données
1.  **Créez la base de données** :
    ```sql
    CREATE DATABASE voyageconnect;
    ```
2.  **Créez un utilisateur** :
    ```sql
    CREATE USER user WITH PASSWORD 'password';
    GRANT ALL PRIVILEGES ON DATABASE voyageconnect TO user;
    ```
3.  **Mettez à jour `src/main/resources/application.properties`** si vos identifiants sont différents.

### 3. Lancement de l'Application (Développement)
La méthode la plus simple pour lancer l'application en mode développement est d'utiliser le plugin Maven Jetty.

```bash
# À la racine du projet (contenant le pom.xml)
mvn jetty:run
```
L'application sera accessible à l'adresse `http://localhost:8080/voyageconnect`.

---

## 📦 Build et Déploiement (Production)

### 1. Compiler le Projet
Cette commande va créer un fichier `.war` prêt à être déployé.

```bash
# Compiler et packager l'application
mvn clean package
```
Le fichier `voyageconnect.war` sera créé dans le répertoire `target/`.

### 2. Déployer sur un Serveur Tomcat
> **Note de compatibilité importante :**
> Ce projet utilise l'API **`javax.servlet`** pour être compatible avec Spring 5. Utilisez un serveur d'applications comme **Apache Tomcat 9**.

1.  **Démarrez votre serveur Apache Tomcat 9.**
2.  **Copiez** le fichier `target/voyageconnect.war` dans le répertoire `webapps/` de votre serveur Tomcat.
    ```bash
    # Exemple de commande (adaptez le chemin vers votre Tomcat)
    cp target/voyageconnect.war /chemin/vers/tomcat/webapps/
    ```
3.  Tomcat déploiera automatiquement l'application.
