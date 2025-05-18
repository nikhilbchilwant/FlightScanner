# Flight Scanner Application

This is a Quarkus based application motivated by Google flights 
application. You can find details about the design in this 
[Design doc.pdf](documentation%2FDesign%20doc.pdf).

### Architecture

![fs-scanner.jpg](documentation%2Ffs-scanner.jpg)

### How to run
Build the Docker images by running the goal 
`clean install -DskipTests -P docker-build` using the Maven 
helper plugin: [https://plugins.jetbrains.com/plugin/7179-maven-helper](Maven Helper Plugin).
Now get the containers up with `docker compose up -d` and call the
GET request using the Postman collection [Flight Scanner.postman_collection.json](documentation%2FFlight%20Scanner.postman_collection.json).