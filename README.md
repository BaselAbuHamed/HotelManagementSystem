# Hotel Management System

## Project Overview

The Hotel Management System is designed to manage various aspects of hotel operations, including room bookings, check-ins, housekeeping, and more. This system provides a comprehensive API for managing hotel resources efficiently.

## Project Resources

### User
- **GET /api/v1/users/{id}**
  - Description: Retrieve a user by their ID.
  - Parameters: 
    - `id` (Path Variable): The ID of the user to retrieve.
  - Response: `UserDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "username": "john_doe",
      "email": "john.doe@example.com",
      "role": "ROLE_USER"
    }
    ```

- **POST /api/v1/users**
  - Description: Create a new user.
  - Request Body: `UserDTO`
  - Example Request:
    ```json
    {
      "username": "jane_doe",
      "password": "password123",
      "email": "jane.doe@example.com",
      "role": "ROLE_USER"
    }
    ```
  - Response: `UserDTO`

- **PUT /api/v1/users/{id}**
  - Description: Update an existing user's details.
  - Parameters:
    - `id` (Path Variable): The ID of the user to update.
  - Request Body: `UserDTO`
  - Example Request:
    ```json
    {
      "username": "john_doe_updated",
      "password": "newpassword123",
      "email": "john.doe_updated@example.com",
      "role": "ROLE_USER"
    }
    ```
  - Response: `UserDTO`

- **DELETE /api/v1/users/{id}**
  - Description: Delete a user by their ID.
  - Parameters:
    - `id` (Path Variable): The ID of the user to delete.
  - Response: `204 No Content`

### Room
- **GET /api/v1/rooms/{id}**
  - Description: Retrieve a room by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the room to retrieve.
  - Response: `RoomDTO`
  - Example Response:
    ```json
    {
      "id": 101,
      "roomNumber": "101A",
      "status": "AVAILABLE",
      "roomClassId": 1,
      "floorId": 2
    }
    ```

- **POST /api/v1/rooms**
  - Description: Create a new room.
  - Request Body: `RoomDTO`
  - Example Request:
    ```json
    {
      "roomNumber": "102B",
      "status": "OCCUPIED",
      "roomClassId": 1,
      "floorId": 2
    }
    ```
  - Response: `RoomDTO`

- **PUT /api/v1/rooms/{id}**
  - Description: Update an existing room's details.
  - Parameters:
    - `id` (Path Variable): The ID of the room to update.
  - Request Body: `RoomDTO`
  - Example Request:
    ```json
    {
      "roomNumber": "103C",
      "status": "MAINTENANCE",
      "roomClassId": 1,
      "floorId": 2
    }
    ```
  - Response: `RoomDTO`

- **DELETE /api/v1/rooms/{id}**
  - Description: Delete a room by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the room to delete.
  - Response: `204 No Content`

### Booking
- **GET /api/v1/bookings/{id}**
  - Description: Retrieve a booking by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the booking to retrieve.
  - Response: `BookingDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "customerId": 1,
      "checkinDate": "2024-06-01",
      "checkoutDate": "2024-06-07",
      "numAdults": 2,
      "numChildren": 1,
      "bookingAmount": 350.00,
      "paymentStatus": "PAID"
    }
    ```

- **POST /api/v1/bookings**
  - Description: Create a new booking.
  - Request Body: `BookingDTO`
  - Example Request:
    ```json
    {
      "customerId": 1,
      "checkinDate": "2024-07-01",
      "checkoutDate": "2024-07-07",
      "numAdults": 2,
      "numChildren": 1,
      "bookingAmount": 400.00,
      "paymentStatus": "PENDING"
    }
    ```
  - Response: `BookingDTO`

- **PUT /api/v1/bookings/{id}**
  - Description: Update an existing booking's details.
  - Parameters:
    - `id` (Path Variable): The ID of the booking to update.
  - Request Body: `BookingDTO`
  - Example Request:
    ```json
    {
      "customerId": 1,
      "checkinDate": "2024-08-01",
      "checkoutDate": "2024-08-07",
      "numAdults": 2,
      "numChildren": 1,
      "bookingAmount": 450.00,
      "paymentStatus": "PAID"
    }
    ```
  - Response: `BookingDTO`

- **DELETE /api/v1/bookings/{id}**
  - Description: Cancel a booking by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the booking to cancel.
  - Response: `204 No Content`

### Housekeeping
- **GET /api/v1/housekeeping/{id}**
  - Description: Retrieve a housekeeping task by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the housekeeping task to retrieve.
  - Response: `HousekeepingDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "roomId": 101,
      "employeeId": 1,
      "taskDate": "2024-06-10",
      "taskDescription": "Clean the room and replace linens",
      "status": "COMPLETED"
    }
    ```

- **POST /api/v1/housekeeping**
  - Description: Create a new housekeeping task.
  - Request Body: `HousekeepingDTO`
  - Example Request:
    ```json
    {
      "roomId": 102,
      "employeeId": 2,
      "taskDate": "2024-06-11",
      "taskDescription": "Clean the bathroom and restock supplies",
      "status": "PENDING"
    }
    ```
  - Response: `HousekeepingDTO`

- **PUT /api/v1/housekeeping/{id}**
  - Description: Update an existing housekeeping task's details.
  - Parameters:
    - `id` (Path Variable): The ID of the housekeeping task to update.
  - Request Body: `HousekeepingDTO`
  - Example Request:
    ```json
    {
      "roomId": 103,
      "employeeId": 3,
      "taskDate": "2024-06-12",
      "taskDescription": "Vacuum the floor and dust surfaces",
      "status": "IN_PROGRESS"
    }
    ```
  - Response: `HousekeepingDTO`

- **DELETE /api/v1/housekeeping/{id}**
  - Description: Delete a housekeeping task by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the housekeeping task to delete.
  - Response: `204 No Content`

### Payment Status
- **GET /api/v1/paymentstatus/{id}**
  - Description: Retrieve a payment status by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the payment status to retrieve.
  - Response: `PaymentStatusDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "statusName": "PAID"
    }
    ```

- **POST /api/v1/paymentstatus**
  - Description: Create a new payment status.
  - Request Body: `PaymentStatusDTO`
  - Example Request:
    ```json
    {
      "statusName": "PENDING"
    }
    ```
  - Response: `PaymentStatusDTO`

- **PUT /api/v1/paymentstatus/{id}**
  - Description: Update an existing payment status' details.
  - Parameters:
    - `id` (Path Variable): The ID of the payment status to update.
  - Request Body: `PaymentStatusDTO`
  - Example Request:
    ```json
    {
      "statusName": "CANCELLED"
    }
    ```
  - Response: `PaymentStatusDTO`

- **DELETE /api/v1/paymentstatus/{id}**
  - Description: Delete a payment status by its ID.
  - Parameters:
    - `id` (Path Variable): The ID of the payment status to delete.
  - Response: `204 No Content`

### Additional Resources
- **BookingAddon**
  - APIs for managing booking addons.

- **CheckinCheckout**
  - APIs for managing check-in and check-out processes.

- **Addon**
  - APIs for managing addons.

- **BookingRoom**
  - APIs for managing booking rooms.

- **Feature**
  - APIs for managing hotel features.

- **Floor**
  - APIs for managing hotel floors.

- **RoomClassBedType**
  - APIs for managing room class bed types.

- **RoomClass**
  - APIs for managing room classes.

- **RoomClassFeature**
  - APIs for managing room class features.

- **RoomStatus**
  - APIs for managing room statuses.

## Students

- Basel Abu Hamed 

## ER Diagram

![ER Diagram](![Untitled (1)](https://github.com/BaselAbuHamed/HotelManagementSystem/assets/107325485/17dcadcb-e3f1-4b7b-8875-324400e45b4a)
)

## Building and Running the Application

### Prerequisites

- Java 17
- Maven
- Docker (optional, for Docker image generation)

### Building the Application

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/HotelManagementSystem.git
    cd HotelManagementSystem
    ```

2. Build the application using Maven:
    ```sh
    mvn clean install
    ```

### Running the Application

#### Running as a JAR

1. Navigate to the `target` directory:
    ```sh
    cd target
    ```

2. Run the JAR file:
    ```sh
    java -jar HotelManagementSystem-0.0.1-SNAPSHOT.jar
    ```

#### Running with Docker

1. Build the Docker image:
    ```sh
    docker build -t yourdockerhubusername/hotel-management-system .
    ```

2. Run the Docker container:
    ```sh
    docker run -p 8080:8080 yourdockerhubusername/hotel-management-system
    ```

### Docker Image

You can find the Docker image for this project on DockerHub:
[DockerHub - HotelManagementSystem](https://hub.docker.com/repository/docker/yourdockerhubusername/hotel-management-system)

## What We Learned

From this project, we learned:

- **Spring Boot Development**: How to create RESTful APIs using Spring Boot.
- **Database Integration**: How to integrate and use PostgreSQL with Spring Data JPA.
- **Security**: How to implement JWT-based authentication and authorization.
- **API Documentation**: How to document APIs using SpringDoc OpenAPI and Swagger UI.
- **Docker**: How to containerize a Spring Boot application using Docker.
- **Team Collaboration**: Working effectively as a team to complete the project.

