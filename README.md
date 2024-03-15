# Employee Management System - Spring Boot (Java)


The Employee Management System is a Java-based web application developed using Spring Boot framework. It provides RESTful APIs for managing employee information, including CRUD operations (Create, Read, Update, Delete), and incorporates global exception handling for error management. 


## Features

1. CRUD Operations:

* Create: Add new employees to the system.
* Read: Retrieve employee details based on ID or other parameters.
* Update: Modify employee information such as name, department, and contact details.
* Delete: Remove employees from the system.
* Global Exception Handling:

2. MySQL Database Integration:
* Use of Spring Data JPA and Hibernate to map entities to MySQL database tables.
* Repository class for performing CRUD operations on the database.

3. Centralized exception handling for managing errors and providing meaningful responses.
Custom exception classes for different types of errors (e.g., ResourceNotFoundException, InvalidRequestException).
## Installation and Setup

1. Clone the repository to your local machine:


    git clone https://github.com/Rohini205/StudentCRUD_Operation
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Make sure you have Java Development Kit (JDK) and Maven installed on your machine.
4. Configure database settings in the application.properties file:

        spring.datasource.driver-class-name=com.mysql.jdbc.Driver
        spring.datasource.url=jdbc:mysql://localhost:3306/sms?autoreconnect=true&SSL=false
        spring.datasource.username=root
        spring.datasource.password=root@123
        
        #JPA
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.     dialect.MySQL5Dialect
   ## Repository Class

The StudentRepository interface extends the Spring Data JPA JpaRepository interface, providing methods for CRUD operations on the Student entity.

        import org.springframework.data.jpa.repository. JpaRepository;
        import org.springframework.stereotype.Repository;

    @Repository
    public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {
        
    }
## Running the Application

1. Start the Spring Boot application:
Run the main class (EmployeeManagementSystemApplication) in your IDE.

3. Access the API endpoints using tools like Postman or cURL:
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
For any questions or support, please contact rohinitibile25@gmail.com.
