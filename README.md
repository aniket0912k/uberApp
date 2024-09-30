# Uber App

This is a Spring Boot application for an Uber-like ride-sharing service. The application provides APIs for riders and drivers to manage ride requests, rate each other, handle authentication and much more.

## Technologies Used

- Java
- Spring Boot
- Maven
- PostgreSQL Database with PostGIS extension
- Spring Security
- JWT for authentication
- Open Source Routing Machine (OSRM)
- OpenAPI (Swagger) for API documentation

## Getting Started

### Prerequisites

- Java 21
- Maven 3.6.0 or higher
- A SQL database (PostgreSQL)

### Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/aniket0912k/uberApp.git
    cd uberApp
    ```

2. **Configure the database:**

   Update the `application.properties` file with your database configuration.

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/uberApp
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Install dependencies and build the project:**

    ```sh
    mvn clean install
    ```

4. **Run the application:**

    ```sh
    mvn spring-boot:run
    ```

### API Documentation

The API documentation is available at:

You can also access the OpenAPI documentation in YAML format at api-docs.yaml

### Security

The application uses JWT for authentication. You need to include the JWT token in the `Authorization` header for protected endpoints.

### Example Endpoints

- **Rider Requests a Ride:**

    ```http
    POST /rider/requestRide
    ```

- **Driver Starts a Ride:**

    ```http
    POST /driver/startRide/{rideRequestId}
    ```

- **User Signup:**

    ```http
    POST /auth/signup
    ```

- **User Login:**

    ```http
    POST /auth/login
    ```

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Open a pull request.

## License

This project is licensed under the MIT License.
