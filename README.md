# CourseWork 2022 Backend

This repository contains the **Spring Boot backend** for the "Logical Force of Ukraine" project. It serves as the API layer for the web application, handling requests related to vehicle management, mission planning, and filtering.

## Features
- RESTful API built with **Spring Boot**
- CRUD operations for **cars, filters, and missions**
- Auto-generated vehicle and filter data
- Integration with **PostgreSQL** (or in-memory database)
- Configurable using `application.properties`

---

## 1. Prerequisites
Ensure you have the following installed:

- **JDK 17+** – [Download](https://adoptium.net/)
- **Maven** – [Download](https://maven.apache.org/download.cgi)
- **PostgreSQL** (if using a real database) – [Download](https://www.postgresql.org/)
- **Docker** (optional for running in containers)

---

## 2. Installation & Running

### **Run Locally**
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Vetal0205/CourseWork2022.Backend.git
   cd CourseWork2022.Backend
   ```
2. **Configure the database:**
   - Open `src/main/resources/application.properties`
   - Configure database credentials (default is in-memory H2)

3. **Build the project:**
   ```bash
   mvn clean install
   ```
4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

The backend should be running at `http://localhost:8080`.

---

## 3. API Endpoints

### **Car Management**
| Method | Endpoint | Description |
|--------|---------------------------------|----------------------------------|
| GET    | `/back-end/api/car_entity`      | Retrieve all cars (Implemented in `CarController`) |
| POST   | `/back-end/api/car_entity`      | Add a new car |
| PUT    | `/back-end/api/car_entity/{id}` | Update an existing car |
| DELETE | `/back-end/api/car_entity/{id}` | Delete a car |

### **Mission Management**
| Method | Endpoint | Description |
|--------|------------------------------------|------------------------------|
| GET    | `/back-end/api/mission_entity`   | Retrieve all missions |
| POST   | `/back-end/api/mission_entity`   | Add a new mission |

### **Filters Management**
| Method | Endpoint | Description |
|--------|-----------------------------------|------------------------------|
| GET    | `/back-end/api/filter_entity`    | Retrieve available filters |

---

## 4. Running with Docker

To run the backend using Docker, use the following steps:

1. **Build the Docker image:**
   ```bash
   docker build -t coursework-backend .
   ```
2. **Run the container:**
   ```bash
   docker run -p 8080:8080 coursework-backend
   ```

---

## 5. Using This Backend with the Frontend

This backend is intended to work with the **CourseWork 2022 Frontend**, available at:

👉 [CourseWork 2022 Frontend Repository](https://github.com/Vetal0205/CourseWork2022)

---

## Conclusion
This repository serves as the **backend** for the "Logical Force of Ukraine" project, providing a **robust Spring Boot API**. 
