# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]
### Added
### Changed
### Fixed

## [1.0.0] - 2026-07-31
### Added
- Initial release of Product Catalog REST Microservice (`ppc-ecommerce-product-service`).
- Product Catalog REST APIs: `GET /api/v1/products`, `GET /api/v1/products/{id}`, `POST /api/v1/products`.
- Spring Boot Actuator ALB Health Check endpoint (`/actuator/health`).
- Integrated `ppc-ecommerce-common-sdk` version `1.0.0`.
- Infrastructure as Code (.iac): `tfvars.dev.json`, `tfvars.prod.json` (Fargate Spot 80/20 cost optimization), `local.tf`, `task-definition-template.json`, and S3 sidecar `resources.yml`.
- GitHub Actions CI/CD deployment pipeline (`deploy-to-ecs.yml`).
