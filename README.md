# Student Data Management REST API

This project is a Java web application built with Spring Boot 3 for managing and storing student data in a PostgreSQL database. It provides a single endpoint for creating student records and ensures robustness against invalid input.

## Tech Stack

- Java 21
- Spring Boot 3
- PostgreSQL Database

## Project Information

The Student Data Management REST API project aims to streamline the process of managing student data for a school council. It provides a convenient way to store student information such as names, surnames, student numbers, and grades by course code in a central database.

## Validation Rules

- **Name:** Mandatory field.
- **Surname:** Mandatory field.
- **Student Number:** Mandatory field. Must start with 'B' and contain 9 alphanumeric characters (e.g., B012X00012).
- **Course Code:** Mandatory field. Must consist of 2 uppercase letters followed by 3 digits (e.g., MT101).
- **Grade Value:** Must be between 0 and 100.

## Installation

1. Clone the repository:
   https://github.com/codersait/student-data-api
2. Install dependencies:

## Usage

1. Start the server:
2. Access the API at `http://localhost:port` (replace `port` with the port number configured in your application).

## Endpoints

### Create Student Record

- **URL:** `/api/v1/students`
- **Method:** `POST`
- **Request Body:**

```json
{
  "name": "Ali",
  "surname": "Yilmaz",
  "stdNumber": "B012X00012",
  "grades": [
    {
      "code": "MT101",
      "value": 90
    },
    {
      "code": "PH101",
      "value": 75
    },
    {
      "code": "CH101",
      "value": 60
    },
    {
      "code": "MT101",
      "value": 70
    },
    {
      "code": "HS101",
      "value": 65
    }
  ]
}
```

## Database

This project uses PostgreSQL to store student data. Ensure that you have PostgreSQL installed and configured before running the application. You may need to update the application.properties file with your PostgreSQL database configuration.
