# Etapa de build
FROM maven:3.8.8-openjdk-17 AS build

# Copiar os arquivos do projeto
WORKDIR /app
COPY sistemaReserva/sistemaReserva/src .

# Executar o build
RUN mvn clean install -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Expor a porta do serviço
EXPOSE 8080

# Copiar o arquivo jar gerado para a imagem final
COPY --from=build /app/target/deploy_render-1.0.0.jar app.jar

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
