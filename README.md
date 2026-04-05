# 🏦 Customer Service - Retail Banking Onboarding System

## 📌 Overview
The **Customer Service** is a core microservice responsible for managing customer onboarding data and maintaining the lifecycle state of a customer in the Retail Banking Onboarding System.

It acts as the **source of truth** for all customer-related information.

---

## 🎯 Responsibilities

- Create and manage customer profiles
- Maintain onboarding lifecycle status
- Provide APIs for retrieving customer details
- Update customer status based on verification outcomes

---

## 🔄 Customer Lifecycle

The onboarding process follows a defined state machine:

INITIATED → DOC_UPLOADED → UNDER_REVIEW → VERIFIED / REJECTED

---

## 🧱 Architecture

This service follows a layered architecture:

```

Controller → Service → Repository → Database

```

---

## 📦 Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation
- Actuator

---

## 📁 Project Structure

```

com.retailbank.customer
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config

```

---

## 🗄️ Database Design

### Customer Table

| Field        | Type        | Description                |
|-------------|------------|----------------------------|
| id          | UUID       | Primary key               |
| first_name  | String     | Customer first name       |
| last_name   | String     | Customer last name        |
| email       | String     | Unique email              |
| phone       | String     | Contact number            |
| dob         | Date       | Date of birth             |
| status      | String     | Onboarding status         |
| created_at  | Timestamp  | Record creation time      |

---

## 🌐 APIs

### ➤ Create Customer
```

POST /customers

```

### ➤ Get Customer by ID
```

GET /customers/{id}

```

### ➤ Update Customer Status (Internal API)
```

PUT /customers/{id}/status

````

---

## 🔐 Validation Rules

- Email must be valid format
- Phone must be 10 digits
- DOB must ensure age ≥ 18
- Status must be one of defined enum values

---

## ⚙️ Running the Service

### Prerequisites
- Java 17
- PostgreSQL running locally

### Steps

```bash
# Clone repo
git clone https://github.com/<your-username>/customer-service.git

# Navigate
cd customer-service

# Run application
./gradlew bootRun
````

---

## 🔗 Integration with Other Services

* Receives updates from **Verification Service**
* Provides customer data to **Document Service**
* Acts as central reference for onboarding state

---

## 📊 Monitoring

Spring Boot Actuator endpoints:

```
/actuator/health
/actuator/metrics
```

---

## 🚀 Future Enhancements

* Add Kafka/JMS integration for event-driven updates
* Add Redis caching
* Implement API Gateway integration
* Add authentication & authorization (JWT)

---

## 👨‍💻 Author

Abhijit Jadhav

---

## 📌 Notes

This service is part of a microservices-based architecture simulating a real-world banking onboarding system with asynchronous processing and service orchestration.

````