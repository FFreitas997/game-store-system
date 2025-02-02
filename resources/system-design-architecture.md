# System Design & Architecture

## Table of Contents

- [Business Requirement & System Design](#business-requirement--system-design)
- [System Architecture](#system-architecture)
- [Database Design (ERD)](#database-design)
- [API Design](#api-design)
- [Spring JPA](#spring-jpa)
- [Spring Services](#spring-services)
- [Redis](#redis)
- [CDN](#cdn)
- [Cloud Storage (Amazon S3)](#cloud-storage)
- [Security (Keycloak)](#security)
- [CI/CD](#cicd)
- [Monitoring](#monitoring)
- [Logging](#logging)
- [Testing](#testing)
- [Frontend (Angular 16 or 17+)](#frontend)
### Spring JPA

Spring Data JPA is a part of the larger Spring Data family. It makes it easy to use data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services. This is an implementation of the Java Persistence API (JPA) specification.

- Entity Relationship
- Named Queries
- Query By Example
- Specifications
- Paging and Sorting
- Projections

### Spring Services

Spring Services are the business logic that is executed when a request is made to the API. It is the layer between the controller and the repository. It is responsible for processing the request, executing the business logic, and returning the response.

### Security

Keycloak is an open-source Identity and Access Management solution. It is a single sign-on solution that allows you to secure your applications and services with little to no code changes. It provides features like user registration, login, and logout, social login, two-factor authentication, and more.

- Configure Keycloak
- Keycloak listeners

### Testing

- Unit Testing
- Integration Testing
- End-to-End Testing
- Mockito
- JUnit
- TestContainers

Note: Later on, we will create an Android application for the same system using **Android Jetpack Compose**.