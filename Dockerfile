FROM alpine/java:21-jdk
WORKDIR /app
COPY target/happyshool.jar .
EXPOSE 8098
ENTRYPOINT ["java", "-jar", "happyshool.jar"]
