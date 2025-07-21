FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=*.jar
COPY ./target/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]