FROM openjdk
MAINTAINER Daniel Santeliz
ADD target/demoJUnit-0.0.1-SNAPSHOT.jar demoJUnit-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demoJUnit-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080