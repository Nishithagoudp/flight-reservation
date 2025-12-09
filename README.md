# Flight Reservation System

A simple Java console-based application that allows a user to:

- Search for flights by destination and date
- Book seats on a selected flight
- View all reservations made
- Manage flights and reservations in-memory (no database)

## Technologies Used
- Java 17
- Maven
- JUnit 5 (for unit testing)
- Eclipse IDE

## How to Run (Eclipse)
1. Import the project as a Maven project.
2. Open `src/main/java/com/nish/flight/Main.java`
3. Right-click → **Run As → Java Application**
4. Use the console menu to interact with the system.

## How to Run Tests
1. Open `src/test/java/com/nish/flight/FlightServiceTest.java`
2. Right-click → **Run As → JUnit Test**

##mvn compile
 Run tests:

## mvn test
Package:

## mvn package
Run application:

java -cp target/classes com.nish.flight.Main

## Design Decisions
- `FlightService` acts as the service layer handling business logic.
- Data is stored in-memory for simplicity (Lists).
- Classes are small, focused, and follow basic OOP principles.
- Unit tests verify search and booking logic, including edge cases.

## Future Improvements (Real World)
- Add database persistence (MySQL/PostgreSQL)
- Add REST APIs (Spring Boot)
- Handle concurrency for seat booking
- Add logging, authentication, and UI


### Running Tests
To execute all JUnit tests:

mvn test

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS


