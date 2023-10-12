FROM openjdk:17-oracle
ADD target/ebi_test_ontology-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080