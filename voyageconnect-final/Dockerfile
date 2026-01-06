# Étape 1 : Build de l'application avec Maven
# Utilise une image officielle Maven pour compiler le projet et créer le .war
FROM maven:3.8.5-openjdk-11 AS build

# Définit le répertoire de travail dans le conteneur
WORKDIR /app

# Copie le fichier pom.xml pour télécharger les dépendances en premier (optimisation du cache Docker)
COPY voyageconnect/pom.xml .

# Télécharge les dépendances
RUN mvn dependency:go-offline

# Copie le reste du code source
COPY voyageconnect/src ./src

# Compile l'application et package le tout dans un fichier .war
# `-DskipTests` est ajouté pour accélérer le build si des tests existaient
RUN mvn clean package -DskipTests


# Étape 2 : Création de l'image d'exécution avec Tomcat
# Utilise une image officielle Tomcat 10
FROM tomcat:10.1-jdk11-corretto

# Supprime le contenu par défaut du répertoire webapps de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copie le fichier .war généré à l'étape de build dans le répertoire webapps de Tomcat
# Le fichier est renommé en ROOT.war pour que l'application soit accessible à la racine de l'URL
COPY --from=build /app/target/voyageconnect.war /usr/local/tomcat/webapps/ROOT.war

# Expose le port 8080 pour que l'application soit accessible de l'extérieur du conteneur
EXPOSE 8080

# La commande par défaut de l'image Tomcat (`catalina.sh run`) démarrera le serveur automatiquement
