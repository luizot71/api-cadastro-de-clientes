FROM adoptopenjdk/openjdk11:alpine
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/cadastro-clientes-api-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT java -jar cadastro-clientes-api-0.0.1-SNAPSHOT.jar