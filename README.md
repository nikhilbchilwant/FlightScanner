# Flight Scanner Application

This is a Quarkus based application motivated by Google flights 
application. You can find details about the design in this 
[Design doc.pdf](documentation%2FDesign%20doc.pdf).

### Architecture


![fs-scanner.jpg](documentation%2Ffs-scanner.jpg)

### Key Architectural Concepts

* **Modular Architecture**: The project is structured into distinct modules ensuring strict separation of concerns:
    * `fs-service`: Core business logic and aggregation strategy.
    * `fs-warehouse`: Data persistence and warehouse operations.
    * `fs-models`: Shared domain models.
    * `fs-mock`: Mock implementations for external dependencies.
* **Event-Driven Architecture**: Utilizes RabbitMQ for asynchronous, non-blocking communication between the scanning service and the warehouse service using the **Publish-Subscribe** pattern.
* **Design Patterns**: Extensively uses enterprise design patterns including:
    * **Strategy Pattern**: For handling multiple airline providers (KLM, Lufthansa) interchangeably.
    * **Proxy Pattern**: For wrapping external API clients with caching and messaging capabilities.
    * **Builder Pattern**: For fluent and immutable object construction.
    * **Repository Pattern**: For abstracting data access logic.
* **Tech Stack**: Built on **Quarkus** (Supersonic Subatomic Java) leveraging **Jakarta EE** standards (CDI, JAX-RS, JPA) and **MicroProfile** for cloud-native resilience and observability.

### How to run
Build the Docker images by running the goal 
`clean install -DskipTests -P docker-build` using the Maven 
helper plugin: [https://plugins.jetbrains.com/plugin/7179-maven-helper](Maven Helper Plugin).
Now get the containers up with `docker compose up -d` and call the
GET request using the Postman collection [Flight Scanner.postman_collection.json](documentation%2FFlight%20Scanner.postman_collection.json).