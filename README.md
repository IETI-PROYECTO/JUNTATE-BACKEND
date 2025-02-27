# PROYECTO IETI: JUNTATE

## Descripción del proyecto

Juntate es una aplicación comunitaria diseñada para conectar personas en Bogotá interesadas en realizar actividades físicas o deportes en grupo. A través de una plataforma intuitiva, los usuarios podrán organizar y unirse a eventos deportivos cercanos, promoviendo la actividad física y la socialización en la ciudad.

## Versión del Lenguaje
- [Java](https://www.oracle.com/java/technologies/downloads/#java17) - Lenguaje de programación

## Dependencias
- [Git](https://git-scm.com/) - Control de versiones
- [Maven](https://maven.apache.org/) - Gestor de dependencias
- [Spring Boot](https://spring.io/projects/spring-boot) - Backend framework
- [React](https://react.dev) - Frontend library
- [MongoDB Atlas](https://www.mongodb.com) - NoSQL Database
- HTML - Markup Language
- CSS - Style sheet language
- [npm](https://www.npmjs.com) - Package Manager for JavaScript

## Enlace al Documento de Planeación

[Trello Board](https://trello.com/invite/b/67a42bd46bf51ac7a194dd0f/ATTI680561e25a311def7fd63f69c3ad48a07B083836/my-trello-board)

## Estructura del proyecto

![image](https://github.com/user-attachments/assets/e8504b6f-f168-471d-84c6-b3a12d266e93)

## Instrucciones de despliegue

### Instalación y ejecución

Para instalar y correr este proyecto de forma local, siga los siguientes pasos:

1. Clonar el repositorio:

```bash
git clone https://github.com/IETI-PROYECTO/JUNTATE-BACKEND
cd JUNTATE-BACKEND
```

2. Build and run:

```bash
mvn clean install
mvn spring-boot:run
```

## Test

Se han implementado pruebas unitarias para la capa de servicios y controladores de la aplicación. Algunas de las pruebas incluyen:

- Obtener una arena por ID
- Obtener todas las arenas
- Crear una arena
- Actualizar una arena
- Eliminar una arena

Ejemplo de prueba:

```java
@Test
void testGetArenaById_Success() throws ArenaException {
    when(arenaService.getArenaById("1")).thenReturn(arena);

    ResponseEntity<Arena> response = arenaController.getArenaById("1");

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals("1", response.getBody().getId());
}
```

## Documentación de API

### **ArenaController** (`/api/arenas`)

#### **Obtener una arena por ID**
- **Método:** `GET`
- **Endpoint:** `/api/arenas/{id}`
- **Respuesta esperada (200 OK):**
```json
{
  "id": "12345",
  "name": "Parque Simón Bolívar",
  "location": "Bogotá, Colombia",
  "capacity": 50
}
```
- **Errores posibles:**
    - `404 Not Found`: Si la arena no existe.

#### **Obtener todas las arenas**
- **Método:** `GET`
- **Endpoint:** `/api/arenas`
- **Respuesta esperada (200 OK):**
```json
[
  {
    "id": "12345",
    "name": "Parque Simón Bolívar",
    "location": "Bogotá, Colombia",
    "capacity": 50
  },
  {
    "id": "67890",
    "name": "Cancha El Campín",
    "location": "Bogotá, Colombia",
    "capacity": 100
  }
]
```

#### **Crear una nueva arena**
- **Método:** `POST`
- **Endpoint:** `/api/arenas/create`
- **Cuerpo de solicitud:**
```json
{
  "name": "Nuevo Parque",
  "location": "Bogotá, Colombia",
  "capacity": 40
}
```
- **Respuesta esperada (201 Created):**
```json
{
  "id": "54321",
  "name": "Nuevo Parque",
  "location": "Bogotá, Colombia",
  "capacity": 40
}
```

#### **Eliminar una arena**
- **Método:** `DELETE`
- **Endpoint:** `/api/arenas/{id}`
- **Respuesta esperada:**
    - `204 No Content`: Eliminación exitosa.
    - `404 Not Found`: Si la arena no existe.

### **UserController** (`/users`)

#### **Obtener todos los usuarios**
- **Método:** `GET`
- **Endpoint:** `/users`
- **Respuesta esperada (200 OK):**
```json
[
  {
    "id": "1",
    "name": "Carlos Pérez",
    "email": "carlos@example.com"
  },
  {
    "id": "2",
    "name": "Ana López",
    "email": "ana@example.com"
  }
]
```

#### **Obtener un usuario por ID**
- **Método:** `GET`
- **Endpoint:** `/users/{id}`
- **Respuesta esperada (200 OK):**
```json
{
  "id": "1",
  "name": "Carlos Pérez",
  "email": "carlos@example.com"
}
```
- **Errores posibles:**
    - `404 Not Found`: Si el usuario no existe.

### **JuntateController** (`/health`)

#### **Verificar estado del servicio**
- **Método:** `GET`
- **Endpoint:** `/health`
- **Respuesta esperada (200 OK):**
```json
"Service is running"
```

## **Documentación Swagger**
Para una documentación más detallada y con pruebas interactivas, accede a Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

## Autores

- Milton Andres Gutierrez Lopez
- Leonardo Piñeros Cortes
- Camilo Murcia Espinosa
- Jeisson Casallas Rozo
- Jhon Sosa Muñoz
- Oscar Lesmes

