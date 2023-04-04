FROM openjdk:latest
COPY pom.xml ./
#RUN mvn clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]