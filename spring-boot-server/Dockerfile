# Dockerfile para desarrollo rápido con Spring Boot + Maven
FROM eclipse-temurin:17-jdk

# Instala Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Expone el puerto de Spring Boot
EXPOSE 8080

# Comando por defecto: arranca la app usando Maven (usa código del volumen)
CMD ["mvn", "spring-boot:run"]