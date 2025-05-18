# Design Patterns Used in Flight Scanner Application

This document catalogs the design patterns implemented in the Flight Scanner application, a Quarkus-based microservices system inspired by Google Flights.

---

## 1. **Builder Pattern**

### Location:
- `fs-models/src/main/java/com/fs/scanner/common/model/Offer.java` (OfferBuilder)
- `fs-models/src/main/java/com/fs/scanner/common/model/FlightDetails.java` (FlightDetailsBuilder)

### Description:
The Builder pattern is used to construct complex objects step by step. Both `Offer` and `FlightDetails` classes implement inner static builder classes that allow for fluent, readable object construction.

### Implementation Details:
- **Offer.OfferBuilder**: Provides methods like `setBidder()`, `setValue()`, `setSource()`, `setDestination()` that return the builder instance, allowing method chaining.
- **FlightDetails.FlightDetailsBuilder**: Provides methods like `setSource()`, `setDestination()`, `setTravelDate()` with a final `build()` method to create the immutable object.

### Benefits:
- Improves code readability
- Allows for immutable object creation
- Provides control over the construction process
- Makes the constructor private, enforcing the use of the builder

### Example Usage:
```java
Offer offer = new Offer.OfferBuilder()
    .setBidder("KLM")
    .setValue(klmOffer.getOfferPrice())
    .setSource(flightDetails.getSource())
    .setDestination(flightDetails.getDestination())
    .createOffer();
```

---

## 2. **Strategy Pattern**

### Location:
- `fs-models/src/main/java/com/fs/scanner/common/handler/OfferProvider.java` (Interface)
- `fs-service/src/main/java/com/fs/scanner/client/KlmClientProxy.java` (Implementation)
- `fs-service/src/main/java/com/fs/scanner/client/LufthansaClientProxy.java` (Implementation)

### Description:
The Strategy pattern defines a family of algorithms (different airline offer providers), encapsulates each one, and makes them interchangeable. The `OfferProvider` interface defines the contract, while different airline clients implement their specific strategies.

### Implementation Details:
- **OfferProvider**: Interface with a `call(FlightDetails)` method
- **KlmClientProxy** and **LufthansaClientProxy**: Concrete implementations that handle airline-specific logic
- Each implementation can be swapped without affecting the client code

### Benefits:
- Easy to add new airline providers without modifying existing code (Open/Closed Principle)
- Encapsulates airline-specific logic
- Promotes code reusability and maintainability

---

## 3. **Proxy Pattern**

### Location:
- `fs-service/src/main/java/com/fs/scanner/client/KlmClientProxy.java`
- `fs-service/src/main/java/com/fs/scanner/client/LufthansaClientProxy.java`

### Description:
The Proxy pattern provides a surrogate or placeholder for another object to control access to it. The client proxy classes act as intermediaries between the service layer and the actual REST API clients.

### Implementation Details:
- Both proxy classes implement `OfferProvider` and wrap the actual REST client (`KlmApi`, `LufthansaApi`)
- They add additional functionality like:
  - Caching (`@CacheResult`)
  - Message publishing to RabbitMQ
  - Data transformation between different model types
- The proxies control access to the remote services

### Benefits:
- Adds caching layer without modifying the REST clients
- Handles cross-cutting concerns (messaging, logging)
- Provides a unified interface while managing different backend implementations

---

## 4. **Dependency Injection (DI) Pattern**

### Location:
- Throughout the application using Jakarta CDI annotations
- `fs-service/src/main/java/com/fs/scanner/client/AggregationService.java`
- `fs-service/src/main/java/com/fs/scanner/handler/FlightsApi.java`
- `fs-warehouse/src/main/java/com/fs/warehouse/OfferWarehouse.java`

### Description:
Dependency Injection is used extensively throughout the application to manage object lifecycles and dependencies. The Quarkus framework provides CDI container support.

### Implementation Details:
- `@Inject` annotation for dependency injection
- `@ApplicationScoped`, `@RequestScoped`, `@Dependent` for bean scopes
- `@Any` qualifier to inject all implementations of an interface
- `Instance<T>` for programmatic bean lookup

### Benefits:
- Loose coupling between components
- Easier testing through mock injection
- Centralized dependency management
- Automatic lifecycle management

### Example:
```java
@Inject
@Any
Instance<OfferProvider> clients; // Injects all OfferProvider implementations
```

---

## 5. **Repository Pattern**

### Location:
- `fs-warehouse/src/main/java/com/fs/warehouse/entity/OfferRepository.java`

### Description:
The Repository pattern mediates between the domain and data mapping layers, acting like an in-memory collection of domain objects.

### Implementation Details:
- Extends `PanacheRepository<OfferEntity>` from Quarkus
- Provides abstraction over database operations
- Separates persistence logic from business logic

### Benefits:
- Centralized data access logic
- Easier to test business logic in isolation
- Provides a collection-like interface for domain objects
- Simplifies database operations

---

## 6. **Adapter Pattern**

### Location:
- `fs-warehouse/src/main/java/com/fs/warehouse/mapper/OfferMapper.java`
- `fs-service/src/main/java/com/fs/scanner/client/KlmClientProxy.java`
- `fs-service/src/main/java/com/fs/scanner/client/LufthansaClientProxy.java`

### Description:
The Adapter pattern converts the interface of a class into another interface that clients expect. This is used to transform between different model representations.

### Implementation Details:
- **OfferMapper**: Uses MapStruct to convert between `Offer` (domain model) and `OfferEntity` (persistence model)
- **Client Proxies**: Transform between common `FlightDetails`/`Offer` models and airline-specific models (KLM, Lufthansa)

### Benefits:
- Allows incompatible interfaces to work together
- Separates domain models from persistence models
- Enables integration with external systems with different data formats

---

## 7. **Facade Pattern**

### Location:
- `fs-service/src/main/java/com/fs/scanner/client/AggregationService.java`
- `fs-service/src/main/java/com/fs/scanner/handler/FlightsApi.java`

### Description:
The Facade pattern provides a simplified interface to a complex subsystem. The `AggregationService` and `FlightsApi` act as facades to the underlying complexity.

### Implementation Details:
- **AggregationService**: Provides a simple `getOffers()` method that hides the complexity of:
  - Discovering all offer providers
  - Calling them in parallel
  - Collecting and aggregating results
- **FlightsApi**: Provides a simple REST endpoint that orchestrates the entire flow

### Benefits:
- Simplifies the interface for clients
- Reduces coupling between subsystems
- Makes the system easier to use and understand

---

## 8. **Observer Pattern (Publish-Subscribe)**

### Location:
- `fs-service/src/main/java/com/fs/scanner/client/KlmClientProxy.java`
- `fs-service/src/main/java/com/fs/scanner/client/LufthansaClientProxy.java`
- `fs-warehouse/src/main/java/com/fs/warehouse/OfferWarehouse.java`

### Description:
The Observer pattern (implemented as Publish-Subscribe via RabbitMQ) defines a one-to-many dependency between objects. When offers are received, they're published to a message queue, and the warehouse service observes and reacts to these events.

### Implementation Details:
- **Publishers**: Client proxies use `@Channel("offers")` with `Emitter<Offer>` to publish offers
- **Subscriber**: `OfferWarehouse` uses `@Incoming("offers")` to consume and persist offers
- Decouples offer retrieval from offer persistence

### Benefits:
- Loose coupling between publishers and subscribers
- Asynchronous processing
- Scalability through message queuing
- Multiple subscribers can react to the same event

---

## 9. **Template Method Pattern (Implicit)**

### Location:
- Through the `OfferProvider` interface and its implementations

### Description:
While not explicitly implemented, the pattern is present in how different airline clients follow the same algorithm structure but with varying implementations.

### Implementation Details:
- All providers follow the same flow: receive flight details → call external API → transform response → publish to queue → return offer
- The specific API call and transformation logic varies per implementation

---

## 10. **Singleton Pattern**

### Location:
- Various `@ApplicationScoped` beans throughout the application

### Description:
The Singleton pattern ensures a class has only one instance. Quarkus CDI manages this through the `@ApplicationScoped` annotation.

### Implementation Details:
- `OfferRepository`, `OfferWarehouse`, and API interfaces are application-scoped
- The CDI container ensures only one instance exists per application

### Benefits:
- Controlled access to shared resources
- Reduced memory footprint
- Consistent state across the application

---

## 11. **Factory Pattern (CDI Container)**

### Location:
- Implicit through Jakarta CDI and Quarkus framework

### Description:
The CDI container acts as a factory, creating and managing bean instances based on annotations and configuration.

### Implementation Details:
- `@RestClient` annotation creates REST client instances
- `@Inject` triggers factory methods in the CDI container
- Scope annotations determine creation strategy

---

## 12. **Cache-Aside Pattern**

### Location:
- `fs-service/src/main/java/com/fs/scanner/client/KlmClientProxy.java`
- `fs-service/src/main/java/com/fs/scanner/client/LufthansaClientProxy.java`
- `fs-service/src/main/java/com/fs/scanner/client/FlightDetailsCacheKeyGenerator.java`

### Description:
The Cache-Aside pattern loads data on demand into a cache from a data store.

### Implementation Details:
- `@CacheResult` annotation on `call()` methods
- Custom `FlightDetailsCacheKeyGenerator` creates composite cache keys
- Cache is checked before making external API calls

### Benefits:
- Reduces latency for repeated requests
- Decreases load on external services
- Improves application performance

---

## Summary

The Flight Scanner application demonstrates a well-architected system using multiple design patterns:

- **Creational Patterns**: Builder, Singleton, Factory (via CDI)
- **Structural Patterns**: Proxy, Adapter, Facade
- **Behavioral Patterns**: Strategy, Observer (Pub-Sub), Template Method

These patterns work together to create a maintainable, scalable, and extensible microservices architecture that can easily accommodate new airline providers and features.

---

## Architecture Highlights

- **Microservices Architecture**: Separation of concerns with fs-service, fs-warehouse, and fs-mock modules
- **Event-Driven Design**: Using RabbitMQ for asynchronous communication
- **REST API Integration**: MicroProfile REST Client for external service calls
- **Caching Strategy**: Quarkus Cache for performance optimization
- **Persistence**: JPA/Hibernate with Panache for simplified data access
- **Containerization**: Docker support for deployment

This combination of patterns and architectural decisions results in a robust, production-ready application.
