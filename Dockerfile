# Étape 1 : Build le projet avec Maven
FROM maven:3.9.9-eclipse-temurin-17 AS builder

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers pom.xml et sources
COPY pom.xml .
COPY src ./src

# Compiler le projet et créer le JAR
RUN mvn clean package -DskipTests

# Étape 2 : Image légère pour exécuter le JAR
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copier le JAR depuis l'image builder
COPY --from=builder /app/target/mairie-ticket-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port 8088
EXPOSE 8088

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
