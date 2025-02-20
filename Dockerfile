FROM maven:3.8.6-openjdk-18-slim as BUILD
WORKDIR /home
COPY pom.xml .
RUN mvn verify --fail-never
COPY src ./src
RUN mvn clean install

FROM tomcat:10.0.26-jre17
COPY --from=BUILD /home/target/practica-jpa-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]
