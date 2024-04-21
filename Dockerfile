FROM amazoncorretto:11-alpine-jdk

COPY  target/queenweb-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java", "-war", "/app.war"]
