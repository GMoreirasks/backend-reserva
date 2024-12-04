# Etapa de build
FROM maven:3.8.5-openjdk-17 as builder

# Definir o diretório de trabalho
WORKDIR /sistemaReserva/app

# Copiar o arquivo pom.xml e a pasta src
COPY sistemaReserva/pom.xml .
COPY sistemaReserva/src .

# Executar o build
RUN mvn clean install -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Expor a porta do serviço
EXPOSE 8080

# Copiar o arquivo jar gerado para a imagem final
# Ajuste o caminho conforme a estrutura de pastas
COPY --from=builder /app/target/sistemaReserva-0.0.1-SNAPSHOT.jar app.jar
# Adicione essa etapa após o RUN mvn clean install
RUN ls -al /app/target
# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
