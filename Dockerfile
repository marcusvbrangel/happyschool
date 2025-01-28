FROM alpine/java:21-jdk
WORKDIR /app
COPY target/eazyshool.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]