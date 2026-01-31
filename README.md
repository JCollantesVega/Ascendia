# Ascendia - Plataforma de Mentorías Pay-per-Session

Ascendia es una plataforma Fullstack diseñada para conectar mentores y aprendices bajo un modelo de "pago por sesión". El proyecto facilita la gestión de mentorías de forma eficiente, segura y escalable.

## 🚀 Tecnologías Utilizadas

Este proyecto utiliza un stack moderno y robusto:

- **Backend:** Java 17+ con **Spring Boot 3** (Spring Security, Spring Data JPA).
- **Frontend:** **Angular** (versión actual) con una interfaz reactiva y modular.
- **Base de Datos:** PostgreSQL (o MySQL, según tu configuración).
- **Contenedores:** **Docker** y **Docker Compose** para orquestación de servicios.
- **Gestión de dependencias:** Maven (Backend) y NPM (Frontend).

## 🏗️ Arquitectura del Proyecto

El repositorio sigue una estructura de **Monorepo**, facilitando el control de versiones de todo el ecosistema en un solo lugar:

```
ascendia/
├── backend/          # API REST con Spring Boot
├── frontend/         # SPA con Angular
├── docker-compose.yml # Orquestación de contenedores
└── README.md
```
## 🛠️ Requisitos Previos

Para ejecutar el proyecto localmente, es necesario tener instalado:
- Docker y Docker Compose
- Git
- JDK 21.
- Node.js y Angular CLI

## ⚙️ Instalación y Configuración

Para levantar todo el entorno, sigue los siguientes pasos:
### 1. Clonar el repositorio:
```
git clone https://github.com/JCollantesVega/Ascendia.git
cd Ascendia
```

### 2. Levantar con Docker
```
docker-compose up --build
```

### 3.Acceder a la aplicación
- Frontend: http://localhost:4200
- Backend API: http://localhost:8080
- Base de datos: Acceso vía puerto 5432

## 📄 Características Principales
- Gestión de usuarios.
- Sistema Pay-per_Session.
- Dashboard Personalizado.
- Contenerización Completa

## 🛡️ Seguridad y API
El backend implementa Spring Security para proteger los endpoints. Las peticiones desde el frontend están configuradas para manejar la autenticación (ej. JWT) y el intercambio de recursos de origen cruzado (CORS).
