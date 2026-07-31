# 🛒 `ppc-ecommerce-product-service`

Product Catalog REST Microservice for PPC E-Commerce Ecosystem.

## 📌 Features
- Product Catalog REST APIs (`GET /api/v1/products`, `POST /api/v1/products`)
- Spring Boot 3.4.2 / 4.x & Java 21
- Lombok & Spring Boot Actuator (`/actuator/health`)
- Consumes `ppc-ecommerce-common-sdk` DTOs

## ⚙️ Configuration
Dynamic placeholders in `application.properties`:
- Port: `${PORT:8081}`
- Profile: `${SPRING_PROFILES_ACTIVE:dev}`

## 🛠️ Local Run
```bash
mvn spring-boot:run
```
