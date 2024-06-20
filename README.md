# Hotel Management System

## Project Overview

The Hotel Management System is designed to manage various aspects of hotel operations, including room bookings, check-ins, housekeeping, and more. This system provides a comprehensive API for managing hotel resources efficiently.

### SwaggerHub API Documentation

The API documentation can be found on SwaggerHub:

[Hotel Management System API Documentation](https://app.swaggerhub.com/apis-docs/BASEL76ZIYAD24/Hotel-Management-System-API/1.0)

## Project Resources

## User
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

## Room
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

## Booking
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

## Housekeeping
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

## Payment Status
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

## BookingAddon
- **GET /api/v1/bookingaddons/{bookingId}/{addonId}**
  - Description: Retrieve a booking addon by booking ID and addon ID.
  - Parameters: 
    - `bookingId` (Path Variable): The ID of the booking.
    - `addonId` (Path Variable): The ID of the addon.
  - Response: `BookingAddonDTO`
  - Example Response:
    ```json
    {
      "bookingId": 1,
      "addonId": 2,
      "addonName": "Breakfast",
      "price": 15.0
    }
    ```

- **POST /api/v1/bookingaddons**
  - Description: Create a new booking addon.
  - Request Body: `BookingAddonDTO`
  - Example Request:
    ```json
    {
      "bookingId": 1,
      "addonId": 2,
      "addonName": "Breakfast",
      "price": 15.0
    }
    ```
  - Response: `BookingAddonDTO`

- **PUT /api/v1/bookingaddons/{bookingId}/{addonId}**
  - Description: Update an existing booking addon.
  - Parameters:
    - `bookingId` (Path Variable): The ID of the booking.
    - `addonId` (Path Variable): The ID of the addon.
  - Request Body: `BookingAddonDTO`
  - Example Request:
    ```json
    {
      "bookingId": 1,
      "addonId": 2,
      "addonName": "Breakfast",
      "price": 20.0
    }
    ```
  - Response: `BookingAddonDTO`

- **DELETE /api/v1/bookingaddons/{bookingId}/{addonId}**
  - Description: Delete a booking addon by booking ID and addon ID.
  - Parameters:
    - `bookingId` (Path Variable): The ID of the booking.
    - `addonId` (Path Variable): The ID of the addon.
  - Response: `204 No Content`

## CheckinCheckout
- **GET /api/v1/checkincheckouts/{id}**
  - Description: Retrieve a check-in/check-out record by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the check-in/check-out record.
  - Response: `CheckinCheckoutDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "bookingId": 1,
      "checkinDate": "2024-01-01",
      "checkoutDate": "2024-01-05",
      "checkedIn": true,
      "checkedOut": false
    }
    ```

- **POST /api/v1/checkincheckouts**
  - Description: Create a new check-in/check-out record.
  - Request Body: `CheckinCheckoutDTO`
  - Example Request:
    ```json
    {
      "bookingId": 1,
      "checkinDate": "2024-01-01",
      "checkoutDate": "2024-01-05",
      "checkedIn": true,
      "checkedOut": false
    }
    ```
  - Response: `CheckinCheckoutDTO`

- **PUT /api/v1/checkincheckouts/{id}**
  - Description: Update an existing check-in/check-out record.
  - Parameters:
    - `id` (Path Variable): The ID of the check-in/check-out record.
  - Request Body: `CheckinCheckoutDTO`
  - Example Request:
    ```json
    {
      "bookingId": 1,
      "checkinDate": "2024-01-01",
      "checkoutDate": "2024-01-05",
      "checkedIn": true,
      "checkedOut": true
    }
    ```
  - Response: `CheckinCheckoutDTO`

- **DELETE /api/v1/checkincheckouts/{id}**
  - Description: Delete a check-in/check-out record by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the check-in/check-out record.
  - Response: `204 No Content`


## Addon
- **GET /api/v1/addons/{id}**
  - Description: Retrieve an addon by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the addon.
  - Response: `AddonDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "addonName": "Breakfast",
      "price": 15.0
    }
    ```

- **POST /api/v1/addons**
  - Description: Create a new addon.
  - Request Body: `AddonDTO`
  - Example Request:
    ```json
    {
      "addonName": "Breakfast",
      "price": 15.0
    }
    ```
  - Response: `AddonDTO`

- **PUT /api/v1/addons/{id}**
  - Description: Update an existing addon.
  - Parameters:
    - `id` (Path Variable): The ID of the addon.
  - Request Body: `AddonDTO`
  - Example Request:
    ```json
    {
      "addonName": "Dinner",
      "price": 20.0
    }
    ```
  - Response: `AddonDTO`

- **DELETE /api/v1/addons/{id}**
  - Description: Delete an addon by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the addon.
  - Response: `204 No Content`
    
## BookingRoom
- **GET /api/v1/bookingrooms/{bookingId}/{roomId}**
  - Description: Retrieve a booking room by booking ID and room ID.
  - Parameters:
    - `bookingId` (Path Variable): The ID of the booking.
    - `roomId` (Path Variable): The ID of the room.
  - Response: `BookingRoomDTO`
  - Example Response:
    ```json
    {
      "bookingId": 1,
      "roomId": 101,
      "checkinDate": "2024-01-01",
      "checkoutDate": "2024-01-05"
    }
    ```

- **POST /api/v1/bookingrooms**
  - Description: Create a new booking room.
  - Request Body: `BookingRoomDTO`
  - Example Request:
    ```json
    {
      "bookingId": 1,
      "roomId": 101,
      "checkinDate": "2024-01-01",
      "checkoutDate": "2024-01-05"
    }
    ```
  - Response: `BookingRoomDTO`

- **PUT /api/v1/bookingrooms/{bookingId}/{roomId}**
  - Description: Update an existing booking room.
  - Parameters:
    - `bookingId` (Path Variable): The ID of the booking.
    - `roomId` (Path Variable): The ID of the room.
  - Request Body: `BookingRoomDTO`
  - Example Request:
    ```json
    {
      "bookingId": 1,
      "roomId": 101,
      "checkinDate": "2024-01-02",
      "checkoutDate": "2024-01-06"
    }
    ```
  - Response: `BookingRoomDTO`

- **DELETE /api/v1/bookingrooms/{bookingId}/{roomId}**
  - Description: Delete a booking room by booking ID and room ID.
  - Parameters:
    - `bookingId` (Path Variable): The ID of the booking.
    - `roomId` (Path Variable): The ID of the room.
  - Response: `204 No Content`

## Feature
- **GET /api/v1/features/{id}**
  - Description: Retrieve a feature by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the feature.
  - Response: `FeatureDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "featureName": "WiFi"
    }
    ```

- **POST /api/v1/features**
  - Description: Create a new feature.
  - Request Body: `FeatureDTO`
  - Example Request:
    ```json
    {
      "featureName": "WiFi"
    }
    ```
  - Response: `FeatureDTO`

- **PUT /api/v1/features/{id}**
  - Description: Update an existing feature.
  - Parameters:
    - `id` (Path Variable): The ID of the feature.
  - Request Body: `FeatureDTO`
  - Example Request:
    ```json
    {
      "featureName": "Swimming Pool"
    }
    ```
  - Response: `FeatureDTO`

- **DELETE /api/v1/features/{id}**
  - Description: Delete a feature by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the feature.
  - Response: `204 No Content`

## Floor
- **GET /api/v1/floors/{id}**
  - Description: Retrieve a floor by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the floor.
  - Response: `FloorDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "floorNumber": 2
    }
    ```

- **POST /api/v1/floors**
  - Description: Create a new floor.
  - Request Body: `FloorDTO`
  - Example Request:
    ```json
    {
      "floorNumber": 2
    }
    ```
  - Response: `FloorDTO`

- **PUT /api/v1/floors/{id}**
  - Description: Update an existing floor.
  - Parameters:
    - `id` (Path Variable): The ID of the floor.
  - Request Body: `FloorDTO`
  - Example Request:
    ```json
    {
      "floorNumber": 3
    }
    ```
  - Response: `FloorDTO`

- **DELETE /api/v1/floors/{id}**
  - Description: Delete a floor by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the floor.
  - Response: `204 No Content`

## RoomClassBedType
- **GET /api/v1/roomclassbedtypes/{roomClassId}/{bedTypeId}**
  - Description: Retrieve a room class bed type by room class ID and bed type ID.
  - Parameters:
    - `roomClassId` (Path Variable): The ID of the room class.
    - `bedTypeId` (Path Variable): The ID of the bed type.
  - Response: `RoomClassBedTypeDTO`
  - Example Response:
    ```json
    {
      "roomClassId": 1,
      "bedTypeId": 2,
      "numBeds": 2
    }
    ```

- **POST /api/v1/roomclassbedtypes**
  - Description: Create a new room class bed type.
  - Request Body: `RoomClassBedTypeDTO`
  - Example Request:
    ```json
    {
      "roomClassId": 1,
      "bedTypeId": 2,
      "numBeds": 2
    }
    ```
  - Response: `RoomClassBedTypeDTO`

- **PUT /api/v1/roomclassbedtypes/{roomClassId}/{bedTypeId}**
  - Description: Update an existing room class bed type.
  - Parameters:
    - `roomClassId` (Path Variable): The ID of the room class.
    - `bedTypeId` (Path Variable): The ID of the bed type.
  - Request Body: `RoomClassBedTypeDTO`
  - Example Request:
    ```json
    {
      "roomClassId": 1,
      "bedTypeId": 2,
      "numBeds": 3
    }
    ```
  - Response: `RoomClassBedTypeDTO`

- **DELETE /api/v1/roomclassbedtypes/{roomClassId}/{bedTypeId}**
  - Description: Delete a room class bed type by room class ID and bed type ID.
  - Parameters:
    - `roomClassId` (Path Variable): The ID of the room class.
    - `bedTypeId` (Path Variable): The ID of the bed type.
  - Response: `204 No Content`


## RoomClass
- **GET /api/v1/roomclasses/{id}**
  - Description: Retrieve a room class by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the room class.
  - Response: `RoomClassDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "className": "Deluxe"
    }
    ```

- **POST /api/v1/roomclasses**
  - Description: Create a new room class.
  - Request Body: `RoomClassDTO`
  - Example Request:
    ```json
    {
      "className": "Deluxe"
    }
    ```
  - Response: `RoomClassDTO`

- **PUT /api/v1/roomclasses/{id}**
  - Description: Update an existing room class.
  - Parameters:
    - `id` (Path Variable): The ID of the room class.
  - Request Body: `RoomClassDTO`
  - Example Request:
    ```json
    {
      "className": "Suite"
    }
    ```
  - Response: `RoomClassDTO`

- **DELETE /api/v1/roomclasses/{id}**
  - Description: Delete a room class by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the room class.
  - Response: `204 No Content`

## RoomClassFeature
- **GET /api/v1/roomclassfeatures/{roomClassId}/{featureId}**
  - Description: Retrieve a room class feature by room class ID and feature ID.
  - Parameters:
    - `roomClassId` (Path Variable): The ID of the room class.
    - `featureId` (Path Variable): The ID of the feature.
  - Response: `RoomClassFeatureDTO`
  - Example Response:
    ```json
    {
      "roomClassId": 1,
      "featureId": 2
    }
    ```

- **POST /api/v1/roomclassfeatures**
  - Description: Create a new room class feature.
  - Request Body: `RoomClassFeatureDTO`
  - Example Request:
    ```json
    {
      "roomClassId": 1,
      "featureId": 2
    }
    ```
  - Response: `RoomClassFeatureDTO`

- **PUT /api/v1/roomclassfeatures/{roomClassId}/{featureId}**
  - Description: Update an existing room class feature.
  - Parameters:
    - `roomClassId` (Path Variable): The ID of the room class.
    - `featureId` (Path Variable): The ID of the feature.
  - Request Body: `RoomClassFeatureDTO`
  - Example Request:
    ```json
    {
      "roomClassId": 1,
      "featureId": 3
    }
    ```
  - Response: `RoomClassFeatureDTO`

- **DELETE /api/v1/roomclassfeatures/{roomClassId}/{featureId}**
  - Description: Delete a room class feature by room class ID and feature ID.
  - Parameters:
    - `roomClassId` (Path Variable): The ID of the room class.
    - `featureId` (Path Variable): The ID of the feature.
  - Response: `204 No Content`

## RoomStatus
- **GET /api/v1/roomstatuses/{id}**
  - Description: Retrieve a room status by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the room status.
  - Response: `RoomStatusDTO`
  - Example Response:
    ```json
    {
      "id": 1,
      "statusName": "Available"
    }
    ```

- **POST /api/v1/roomstatuses**
  - Description: Create a new room status.
  - Request Body: `RoomStatusDTO`
  - Example Request:
    ```json
    {
      "statusName": "Available"
    }
    ```
  - Response: `RoomStatusDTO`

- **PUT /api/v1/roomstatuses/{id}**
  - Description: Update an existing room status.
  - Parameters:
    - `id` (Path Variable): The ID of the room status.
  - Request Body: `RoomStatusDTO`
  - Example Request:
    ```json
    {
      "statusName": "Occupied"
    }
    ```
  - Response: `RoomStatusDTO`

- **DELETE /api/v1/roomstatuses/{id}**
  - Description: Delete a room status by ID.
  - Parameters:
    - `id` (Path Variable): The ID of the room status.
  - Response: `204 No Content`
## Students

- Basel Abu Hamed 

## ER Diagram

![ER Diagram](https://github.com/BaselAbuHamed/HotelManagementSystem/assets/107325485/17dcadcb-e3f1-4b7b-8875-324400e45b4a)

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
[DockerHub - HotelManagementSystem](https://hub.docker.com/r/baselabuhamed/hotel_management_app)

## What We Learned

From this project, we learned:

- **Spring Boot Development**: How to create RESTful APIs using Spring Boot.
- **Database Integration**: How to integrate and use PostgreSQL with Spring Data JPA.
- **Security**: How to implement JWT-based authentication and authorization.
- **API Documentation**: How to document APIs using SpringDoc OpenAPI and Swagger UI.
- **Docker**: How to containerize a Spring Boot application using Docker.
- **Team Collaboration**: Working effectively as a team to complete the project.

