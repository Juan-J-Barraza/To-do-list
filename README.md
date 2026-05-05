# To-Do List API

Este proyecto es una API RESTful desarrollada con **Spring Boot** para la gestión de tareas (To-Do List). Permite realizar operaciones CRUD completas y gestionar el estado de las tareas.

## 🚀 Funcionalidades

- **Gestión de Tareas**: Crear, leer, actualizar y eliminar tareas.
- **Estados de Tarea**: Soporte para estados `PENDING`, `IN_PROGRESS`, y `COMPLETED`.
- **Manejo de Errores**: Sistema global de manejo de excepciones para respuestas consistentes.
- **Persistencia**: Integración con base de datos MySQL.
- **Dockerización**: Configuración lista para desplegar con Docker y Docker Compose.

## 🛠️ Tecnologías Utilizadas

- **Java 21**
- **Spring Boot 4.0.6**
- **Spring Data JPA** (Hibernate)
- **MySQL 8.0**
- **Maven**
- **Docker & Docker Compose**

---

## 📖 Documentación de Endpoints

La URL base para todos los endpoints es: `/api/v1/tasks`

### 1. Crear una Tarea
- **Método**: `POST`
- **Cuerpo (JSON)**: `TaskCreatedDto`
- **Respuesta**: `201 Created`

### 2. Obtener todas las Tareas
- **Método**: `GET`
- **Respuesta**: `200 OK` (Lista de `TaskResponseDto`)

### 3. Obtener Tarea por ID
- **Método**: `GET`
- **Path Variable**: `id`
- **Respuesta**: `200 OK` o `404 Not Found`

### 4. Actualizar una Tarea
- **Método**: `PUT`
- **Path Variable**: `id`
- **Cuerpo (JSON)**: `TaskUpdatedDto`
- **Respuesta**: `200 OK`

### 5. Eliminar una Tarea
- **Método**: `DELETE`
- **Path Variable**: `id`
- **Respuesta**: `204 No Content`

---

## 📄 Ejemplos de JSON

### Request: Crear Tarea (`POST /api/v1/tasks`)
```json
{
  "title": "Aprender Spring Boot",
  "description": "Estudiar la arquitectura de microservicios y REST",
  "creationDate": "2024-05-05"
}
```

### Request: Actualizar Tarea (`PUT /api/v1/tasks/{id}`)
```json
{
  "title": "Aprender Spring Boot (Avanzado)",
  "description": "Completar el curso de seguridad y despliegue",
  "status": "IN_PROGRESS"
}
```

### Response: Detalle de Tarea (`TaskResponseDto`)
```json
{
  "idTask": 1,
  "title": "Aprender Spring Boot",
  "description": "Estudiar la arquitectura de microservicios y REST",
  "status": "PENDING",
  "createdDate": "2024-05-05"
}
```

---

## 🚦 Estados Disponibles

Las tareas pueden tener los siguientes estados:
- `PENDING`: Tarea pendiente de iniciar.
- `IN_PROGRESS`: Tarea en curso.
- `COMPLETED`: Tarea finalizada.

---

## 📦 Ejecución del Proyecto

### Requisitos previos
- Docker y Docker Compose instalados.

### Pasos para iniciar

1. Clona el repositorio.
2. Asegúrate de tener configurado el archivo `.env` con las credenciales de la base de datos.
3. Ejecuta el siguiente comando en la raíz del proyecto:

```bash
docker-compose up --build
```

La aplicación estará disponible en `http://localhost:8080`.

---

## 🏗️ Estructura del Proyecto

- `controllers`: Controladores REST para manejar las peticiones HTTP.
- `dtos`: Objetos de Transferencia de Datos para peticiones y respuestas.
- `models`: Entidades de persistencia (JPA).
- `services`: Lógica de negocio.
- `repositories`: Interfaces para el acceso a datos.
- `enums`: Definiciones de constantes (como estados).
- `utils`: Clases de utilidad.
