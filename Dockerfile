FROM alpine/java:21-jdk
WORKDIR /app
COPY target/eazyshool.jar eazyshool.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]