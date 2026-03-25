# 📚 EV_JD - Evaluación 1

Este repositorio contiene la implementación de la evaluacion 1, usando **Spring Boot** con **PostgreSQL**. Incluye la relación **Muchos a Uno** entre **Courses** e **Instructor**.

---

## 🏗️ Tecnologías

- Java 25  
- Spring Boot 4.0.4 
- Spring Data JPA  
- PostgreSQL  
- Maven  

---

## 🗂️ Estructura principal

- **entity/** → Entidades JPA (`Course`, `Instructor`)  
- **dto/** → DTOs para requests y responses  
- **repository/** → Repositorios JPA  
- **service/** → Lógica de negocio  
- **controller/** → Endpoints REST (`/api/courses`)  

---

## 🔑 Entidades

### Instructor
- `id` (PK)  
- `name`  

### Course
- `id` (PK)  
- `name`  
- `description`  
- `credits`  
- `instructor` (Many-to-One)  

---

## 🚀 Endpoint disponible

### Courses
| Método | Endpoint      | Descripción                     |
|--------|---------------|---------------------------------|
| POST   | /api/courses  | Crea un curso con `instructorId` |

**Ejemplo de request:**

```json
POST /api/courses
{
  "name": "Spring Boot",
  "description": "Curso de backend",
  "credits": 4,
  "instructorId": 1
}
