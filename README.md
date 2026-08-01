# 🛒 PPC E-Commerce Product Microservice

[![Deploy to AWS ECS](https://github.com/PPC2001/ppc-ecommerce-product-service/actions/workflows/deploy-to-ecs.yml/badge.svg)](https://github.com/PPC2001/ppc-ecommerce-product-service/actions/workflows/deploy-to-ecs.yml)
[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Non--Root%20USER%20nobody-blue.svg)](https://www.docker.com/)

---

## 📌 Overview

**`ppc-ecommerce-product-service`** is the Product Catalog REST microservice for the PPC E-Commerce ecosystem. Built with Java 21 and Spring Boot 3.4.2, it manages product catalog inventory, pricing, and availability.

---

## 🏗️ Architecture & SDK Integration

- **Port**: `8081` (Container exposed ports `8081` and `8080`)
- **Shared SDK**: Consumes [`ppc-ecommerce-common-sdk:1.0.1`](https://github.com/PPC2001/ppc-ecommerce-common-sdk) for domain models (`ProductDto`, `ApiResponse<T>`).
- **Container Security**: Runs in Docker as a non-root user (`USER nobody`).

---

## 🚀 REST API Specification

### 1. Actuator Health Check
```http
GET /ppc-ecommerce-product-service/actuator/health
```

### 2. Get All Products
```http
GET /ppc-ecommerce-product-service/api/v1/products
```

### 3. Get Product by ID
```http
GET /ppc-ecommerce-product-service/api/v1/products/{id}
```

### 4. Create New Product
```http
POST /ppc-ecommerce-product-service/api/v1/products
Content-Type: application/json
```
```json
{
  "name": "Wireless Noise-Canceling Headphones",
  "description": "High fidelity audio headphones",
  "price": 199.99,
  "stockQuantity": 50,
  "category": "Electronics"
}
```

---

## ☁️ AWS ECS Fargate Deployment & CI/CD

- **ECR Repository**: `ppc-ecommerce-product-service`
- **ECS Cluster**: `pratik-dev-cluster`
- **ECS Service**: `ppc-ecommerce-product-service-dev`
- **Target Group**: `ppc-product-tg-dev`
- **ALB Path**: `/ppc-ecommerce-product-service/*`
- **CloudWatch Log Group**: `/ecs/ppc-ecommerce-product-task-dev`

---

## 💻 Local Execution

```bash
mvn clean package --settings settings.xml
java -jar target/ppc-ecommerce-product-service-1.0.0.jar
```

Or run via Docker:
```bash
docker build -t ppc-ecommerce-product-service:latest .
docker run -p 8081:8081 ppc-ecommerce-product-service:latest
```
