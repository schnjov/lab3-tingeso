FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} preguntas-service.jar
ENTRYPOINT ["java","-jar","/preguntas-service.jar"]