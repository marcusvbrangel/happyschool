FROM alpine/java:21-jdk
WORKDIR /app
COPY target/happyshool.jar .
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "happyshool.jar"]
