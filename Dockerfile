FROM openjdk:11

ADD ./target/musix-service-0.0.1-SNAPSHOT.jar /usr/src/musix-service-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "musix-service-0.0.1-SNAPSHOT.jar"]