# Ontology Test

## NOTE:

Due to limited time and issues with Docker on my personal laptop I wasn't able to complete my testing of 
application by running it with Docker. However, I've included the Dockerfile and docker-compose.yml files
which can be used to run the application in docker environment.

Apart from this, I've implements all the functional requirements stated in the test task.

## How to run the application

### Prerequisites

- Java 17 (I've used Java 17 sdk) so to run backend application you need jdk 17 on your machine. JAVA_HOME environment variable should be set to the location of Java 17 sdk on your machine.

### Backend

To run backend application you need to run the following command in the backend directory of the project:

```shell
mvn spring-boot:run
```

You will see the following output in the terminal:

```shell
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2023-10-12T23:34:52.938+01:00  INFO 18056 --- [           main] c.e.ontology.EbiTestOntologyApplication  : Starting EbiTestOntologyApplication using Java 17.0.8.1 with PID 18056 (/Users/haideriqbal/Documents/ebi_test_ontology/backend/target/classes started by haideriqbal in /Users/haideriqbal/Documents/ebi_test_ontology/backend)
2023-10-12T23:34:52.940+01:00  INFO 18056 --- [           main] c.e.ontology.EbiTestOntologyApplication  : No active profile set, falling back to 1 default profile: "default"
2023-10-12T23:34:53.442+01:00  INFO 18056 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data MongoDB repositories in DEFAULT mode.
2023-10-12T23:34:53.492+01:00  INFO 18056 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 45 ms. Found 1 MongoDB repository interfaces.
2023-10-12T23:34:53.881+01:00  INFO 18056 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-10-12T23:34:53.890+01:00  INFO 18056 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-10-12T23:34:53.890+01:00  INFO 18056 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.13]
2023-10-12T23:34:53.982+01:00  INFO 18056 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-10-12T23:34:53.983+01:00  INFO 18056 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1000 ms
2023-10-12T23:34:54.207+01:00  INFO 18056 --- [           main] org.mongodb.driver.client                : MongoClient with metadata {"driver": {"name": "mongo-java-driver|sync|spring-boot", "version": "4.9.1"}, "os": {"type": "Darwin", "name": "Mac OS X", "architecture": "x86_64", "version": "13.3.1"}, "platform": "Java/Amazon.com Inc./17.0.8.1+8-LTS"} created with settings MongoClientSettings{readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, journal=null}, retryWrites=true, retryReads=true, readConcern=ReadConcern{level=null}, credential=null, streamFactoryFactory=null, commandListeners=[], codecRegistry=ProvidersCodecRegistry{codecProviders=[ValueCodecProvider{}, BsonValueCodecProvider{}, DBRefCodecProvider{}, DBObjectCodecProvider{}, DocumentCodecProvider{}, CollectionCodecProvider{}, IterableCodecProvider{}, MapCodecProvider{}, GeoJsonCodecProvider{}, GridFSFileCodecProvider{}, Jsr310CodecProvider{}, JsonObjectCodecProvider{}, BsonCodecProvider{}, EnumCodecProvider{}, com.mongodb.client.model.mql.ExpressionCodecProvider@2f14b0f6, com.mongodb.Jep395RecordCodecProvider@5b20706]}, loggerSettings=LoggerSettings{maxDocumentLength=1000}, clusterSettings={hosts=[localhost:27017], srvServiceName=mongodb, mode=SINGLE, requiredClusterType=UNKNOWN, requiredReplicaSetName='null', serverSelector='null', clusterListeners='[]', serverSelectionTimeout='30000 ms', localThreshold='30000 ms'}, socketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=0, receiveBufferSize=0, sendBufferSize=0}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=10000, receiveBufferSize=0, sendBufferSize=0}, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, maintenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[], maxConnecting=2}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=500, serverListeners='[]', serverMonitorListeners='[]'}, sslSettings=SslSettings{enabled=false, invalidHostNameAllowed=false, context=null}, applicationName='null', compressorList=[], uuidRepresentation=JAVA_LEGACY, serverApi=null, autoEncryptionSettings=null, contextProvider=null}
2023-10-12T23:34:54.273+01:00  INFO 18056 --- [localhost:27017] org.mongodb.driver.cluster               : Monitor thread successfully connected to server with description ServerDescription{address=localhost:27017, type=STANDALONE, state=CONNECTED, ok=true, minWireVersion=0, maxWireVersion=21, maxDocumentSize=16777216, logicalSessionTimeoutMinutes=30, roundTripTimeNanos=70823500}
2023-10-12T23:34:54.730+01:00  INFO 18056 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-10-12T23:34:54.737+01:00  INFO 18056 --- [           main] c.e.ontology.EbiTestOntologyApplication  : Started EbiTestOntologyApplication in 2.146 seconds (process running for 2.65)
```

This shows backend has started successfully.

### Frontend

To run frontend application you need to run the following commands in frontend directory of the project:

```shell
npm install && npm start
```

Once thats compiled and run successfully it will open a browser window on `localhost:3000` with the application running on it. Following are the couple of screenshots of the application:

![0eac92e693c1b7959d04155bd45297e1.png](https://imgtr.ee/images/2023/10/12/0eac92e693c1b7959d04155bd45297e1.png)

![a5d6c5ff1000b793acccc860796c1a60.png](https://imgtr.ee/images/2023/10/12/a5d6c5ff1000b793acccc860796c1a60.png)


![e81740b7b6538944239d081c66069f67.png](https://imgtr.ee/images/2023/10/12/e81740b7b6538944239d081c66069f67.png)

The frontend application is pretty simple for now as it just shows list of all ontologies and
when you click on one of the ontology it shows related details as required by the test task.


## Things to improve

- Improve the UI of the frontend application.
- Add unit tests for frontend application.
- Add integration tests for backend application.
- Better handle exceptions in backend application.

## How to run the application in Docker

Provided the relevant files, we can run the application in by using following commands:

```shell
docker-compose up
```
Please Note again: I wasn't able to test this due to issues with Docker on my personal laptop.