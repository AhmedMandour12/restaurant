# 🍽️ Restaurant Management System & Admin Dashboard

![Java](https://img.shields.io/badge/Java-17+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![Angular](https://img.shields.io/badge/Angular-17+-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-Caching-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![MapStruct](https://img.shields.io/badge/MapStruct-DTO_Mapping-blue?style=for-the-badge)

A full-stack, enterprise-grade **Restaurant Management System** built with **Spring Boot** and **Angular**. Designed around clean layered architecture, the platform provides a bilingual (**English / Arabic**) customer storefront and a comprehensive **Admin Dashboard** featuring JWT role-based security, Redis caching with automated invalidation, JPA entity auditing, multi-criteria search, and standardized pagination.

---

## 📋 Table of Contents
- [Architectural Overview](#-architectural-overview)
- [Key Engineering Highlights](#-key-engineering-highlights)
- [Core Functional Modules](#-core-functional-modules)
- [Domain Entity Relationships](#-domain-entity-relationships)
- [Project Structure](#-project-structure)
- [API Endpoints Summary](#-api-endpoints-summary)
- [Getting Started](#-getting-started)
- [Quality Assurance & Testing](#-quality-assurance--testing)
- [Author](#-author)

---

## 🏗️ Architectural Overview

The backend adheres strictly to **Separation of Concerns (SoC)** and **Clean Code** principles, isolating HTTP transport, business logic, data persistence, and cross-cutting concerns into dedicated layers:

```text
┌──────────────────────────────────────────────────────────────────────┐
│                        Angular SPA Client                            │
│  (Storefront • Admin Dashboard • Route Guards • EN/AR i18n Switcher) │
└──────────────────────────────────┬───────────────────────────────────┘
                                   │ REST / JSON + JWT Bearer Token
                                   ▼
┌──────────────────────────────────────────────────────────────────────┐
│                       Spring Boot REST API                           │
│  ┌────────────────┐   ┌──────────────────┐   ┌────────────────────┐  │
│  │  Controllers   │──▶│  Services / Impl │──▶│    Repositories    │  │
│  │ (Validation)   │   │ (Business Logic) │   │ (Spring Data JPA)  │  │
│  └────────────────┘   └────────┬─────────┘   └─────────┬──────────┘  │
│           │                    │                       │             │
│           ▼                    ▼                       ▼             │
│  ┌────────────────┐   ┌──────────────────┐   ┌────────────────────┐  │
│  │   MapStruct    │   │  Redis Cache     │   │  Relational DB     │  │
│  │ (Entity ↔ DTO) │   │ (TTL & Eviction) │   │  (+ JPA Auditing)  │  │
│  └────────────────┘   └──────────────────┘   └────────────────────┘  │
│                                                                      │
│  Cross-Cutting: JWT Security Filter • Global Exception Handler • i18n│
└──────────────────────────────────────────────────────────────────────┘
