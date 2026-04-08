# #4 Implement Customer Entity and Database Integration 

@https://github.com/Abhijit3562/customer-service/issues/4


# 🧠 Customer Service - Entity & Database Integration Notes

---

## 📌 Overview

This document covers the key concepts used while implementing the **Customer Entity** and integrating it with the database using Spring Boot and JPA.

---

# 🏗️ 1. JPA Entity Mapping

## 🔹 What is an Entity?

An Entity represents a table in the database.

```java
@Entity
public class Customer {
}
````

---

## 🔹 Table Mapping

```java
@Table(name = "customers")
```

Used to explicitly define table name.

---

## 🔹 Primary Key

```java
@Id
@GeneratedValue
private UUID id;
```

* `@Id` → Marks primary key
* `@GeneratedValue` → Auto-generates value

---

## 🔹 Column Mapping

```java
@Column(name = "first_name")
private String firstName;
```

Used to map Java field → DB column.

---

# 🧬 2. Data Types & Best Practices

| Field      | Java Type     | Reason                    |
| ---------- | ------------- | ------------------------- |
| id         | UUID          | Unique & distributed-safe |
| phone      | String        | Avoid numeric issues      |
| dob        | LocalDate     | No timezone needed        |
| timestamps | LocalDateTime | Stores date + time        |

---

# ⚠️ Phone Number Handling

❌ Avoid:

```java
Long phone;
```

✅ Use:

```java
String phone;
```

Reason:

* Preserves formatting
* Avoids leading zero loss
* Not used for calculations

---

# 🔢 3. Enum Mapping

## 🔹 Enum Example

```java
public enum CustomerStatus {
    INITIATED,
    DOC_UPLOADED,
    UNDER_REVIEW,
    VERIFIED,
    REJECTED
}
```

---

## ❌ Using ORDINAL (Not Recommended)

```java
@Enumerated(EnumType.ORDINAL)
```

Problem:

* Stores numeric values (0,1,2...)
* Changing enum order breaks data

---

## ✅ Using STRING (Recommended)

```java
@Enumerated(EnumType.STRING)
```

Benefits:

* Stores readable values
* Safe for future changes

---

# 🗄️ 4. Hibernate DDL Auto Generation

## 🔹 Property

```properties
spring.jpa.hibernate.ddl-auto=update
```

---

## 🔹 Options

| Value    | Behavior                |
| -------- | ----------------------- |
| create   | Drops & recreates table |
| update   | Updates schema          |
| validate | Checks schema only      |
| none     | No action               |

---

## ⚠️ Recommendation

* Use `update` for development
* Avoid `create` in production

---

# 🔍 5. Understanding Hibernate Logs

Example:

```sql
create table customers (...)
```

👉 Means:

* Entity detected
* Table created successfully

---

## ⚠️ Log Messages

```
Database driver: undefined/unknown
```

👉 Can be ignored if DB works

```
No JTA platform available
```

👉 Safe to ignore for simple apps

---

# 📦 6. Repository Layer

## 🔹 What is Repository?

Interface to interact with database.

```java
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
```

---

## 🔹 Benefits

* No boilerplate SQL
* Built-in CRUD operations
* Pagination & sorting support

---

# 🧠 7. JPA Auditing

## 🔹 Purpose

Automatically populate timestamps.

---

## 🔹 Enable Auditing

```java
@EnableJpaAuditing
```

---

## 🔹 Entity Setup

```java
@EntityListeners(AuditingEntityListener.class)
```

---

## 🔹 Fields

```java
@CreatedDate
private LocalDateTime createdAt;

@LastModifiedDate
private LocalDateTime updatedAt;
```

---

## ⚠️ Common Mistakes

* Missing `@EnableJpaAuditing`
* Missing `@EntityListeners`
* Wrong imports

---

# 🧱 8. Base Entity (Best Practice)

```java
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedDate
    protected LocalDateTime updatedAt;
}
```

---

## ✅ Usage

```java
public class Customer extends BaseEntity
```

---

# 🔗 9. Database Integration Flow

```
Entity → JPA → Hibernate → SQL → PostgreSQL
```

---

# 🚀 Key Takeaways

* Use UUID for IDs
* Use STRING enum mapping
* Use String for phone numbers
* Enable JPA auditing properly
* Understand Hibernate logs
* Use repository for DB interaction

---

# 📌 Interview Tips

* Be ready to explain enum mapping difference
* Explain why phone is String
* Explain ddl-auto options
* Explain auditing setup
* Explain entity lifecycle

---

````

---

# 🔥 What to do now

1️⃣ Create a folder:
```bash
/docs
````

2️⃣ Add file:

```
customer-entity-notes.md
```

3️⃣ Commit:

```bash
git add docs/
git commit -m "Added notes for Customer Entity and DB integration"
git push
```

---
