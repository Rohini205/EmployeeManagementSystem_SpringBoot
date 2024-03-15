# Employee Management System - Spring Boot (Java)


The Employee Management System is a Java-based web application developed using Spring Boot framework. It provides RESTful APIs for managing employee information, including CRUD operations (Create, Read, Update, Delete), and incorporates global exception handling for error management. 


## Features

CRUD Operations:

Create: Add new employees to the system.
Read: Retrieve employee details based on ID or other parameters.
Update: Modify employee information such as name, department, and contact details.
Delete: Remove employees from the system.
Global Exception Handling:

Centralized exception handling for managing errors and providing meaningful responses.
Custom exception classes for different types of errors (e.g., ResourceNotFoundException, InvalidRequestException).
## Running the Application

Start the Spring Boot application:
Run the main class (EmployeeManagementSystemApplication) in your IDE.
Access the API endpoints using tools like Postman or cURL:
Base URL: http://localhost:8080/Employees
Use HTTP methods (GET, POST, PUT, DELETE) for different operations.
## API Endpoints

* GET /employees/All: Get all employees.
* GET /employees/emp/{id}: Get employee by ID.
* POST /Employee/save: Create a new employee.
* PUT /employees/update/{id}: Update employee details.
* DELETE /employees/delete/{id}: Delete employee by ID.

Example request for creating a new employee:

    POST /employee/save
    {
         "id": 1,
        "name": "John Doe"
    }

## Global Exception Handling

The project includes a global exception handling mechanism using Spring's @ControllerAdvice and @ExceptionHandler annotations. The GlobalExceptionHandler class handles exceptions and provides appropriate error responses to clients.
## Contributing

Contributions to the Employee Management System project are welcome! Please fork the repository, make your changes, and submit a pull request with a detailed description of your modifications.
## Contact
For any questions or support, please contact [rohinitibile25@gmail.com].
