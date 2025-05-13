# 🛠️ ProductUserRESTApi

A RESTful Spring Boot API to manage **Users** and their associated **Products**, with full CRUD functionality and secure role-based access. Built with Spring Boot 3.x, Spring Security, and Spring Data JPA, this application demonstrates clean architecture, layered separation of concerns, and practical in-memory authentication for role management.

---

## 📌 Features

- 🔹 CRUD operations on `User` and `Product` entities
- 🔹 One-to-Many relationship: a User can own multiple Products
- 🔹 In-memory authentication using Spring Security
- 🔹 Role-based access to secure endpoints
- 🔹 Differentiated access for `ADMIN` and `USER` roles

---

## 🔐 In-Memory User Roles

| Username | Password   | Role  | Can Access                         |
|----------|------------|-------|------------------------------------|
| `admin`  | `admin123` | ADMIN | `/users/**`, `/products/**`       |
| `user`   | `user123`  | USER  | `/products/**` only                |

---

## 🔗 API Access Permissions

| Endpoint            | Method | Role(s) Allowed   | Description            |
|---------------------|--------|-------------------|------------------------|
| `/products`         | GET    | ADMIN, USER       | List all products      |
| `/products`         | POST   | ADMIN, USER       | Create a product       |
| `/products/{id}`    | PUT    | ADMIN             | Update product by ID   |
| `/products/{id}`    | DELETE | ADMIN             | Delete product by ID   |
| `/users`            | GET    | ADMIN             | List all users         |
| `/users`            | POST   | ADMIN             | Create a new user      |

---

## 🧰 Technologies Used

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **MySQL / H2 (configurable)**
- **Maven**

---

## 📄 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
