# Calculator Application

## Overview

The Calculator Application is a Spring Boot project designed to perform basic arithmetic operations including addition, subtraction, multiplication, and division. The application incorporates Micrometer for performance metrics and integrates with Prometheus for comprehensive monitoring and analysis.

## Features

- **Arithmetic Operations**: Perform addition, subtraction, multiplication, and division via RESTful API endpoints.
- **Metrics Tracking**: Monitors the time taken for operations and counts the number of each operation performed using Micrometer.
- **Error Handling**: Includes error messages for division by zero and invalid input scenarios.

## Prerequisites

- **Java 19+**: Ensure Java 19 or higher is installed.
- **Maven**: Required for building the project.
- **Prometheus**: For collecting and analyzing metrics (optional but recommended).

## Setup and Installation

1. **Clone the Repository**

   Clone the repository from GitHub and navigate into the project directory:

   ```bash
   git clone https://github.com/yourusername/calculator.git
   cd calculator
Build the Project

Compile and package the application using Maven:

bash
Copy code
mvn clean install
This command generates the JAR file in the target directory.

Run the Application

Start the application with the following command:

bash
Copy code
java -jar target/calculator-0.0.1-SNAPSHOT.jar
The application will run on http://localhost:8080.

Access the API

The following endpoints are available:

Addition: GET /api/calculator/add?num1={num1}&num2={num2}
Subtraction: GET /api/calculator/subtract?num1={num1}&num2={num2}
Multiplication: GET /api/calculator/multiply?num1={num1}&num2={num2}
Division: GET /api/calculator/divide?num1={num1}&num2={num2}
Note: For division, if num2 is zero, an error message "Error: Division by zero is not allowed." is returned.

Metrics and Monitoring

Metrics Exposure: Metrics are exposed at /actuator/prometheus. You can integrate Prometheus to scrape these metrics.
Prometheus Configuration: Set up Prometheus to scrape data from the /actuator/prometheus endpoint for monitoring and analysis.
Configuration
Application Properties: Configuration settings can be found in src/main/resources/application.properties. Modify these settings to suit your environment.
Error Handling
400 Bad Request: Returned for invalid or missing parameters.
Division by Zero: Returns "Error: Division by zero is not allowed." if division by zero is attempted.
Rate Limiting
Limit: 1000 requests per hour (Note: This rate limit is theoretical and requires additional setup for enforcement).
Handling: A 429 Too Many Requests status code would be returned if the rate limit is exceeded (additional implementation required).
Additional Resources
Prometheus: Used for monitoring and metrics collection.
Grafana: Optional tool for visualizing Prometheus metrics.
Micrometer: Provides metrics instrumentation for the application.
