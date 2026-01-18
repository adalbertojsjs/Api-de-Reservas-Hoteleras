#  Sistema de Reservas

Proyecto backend desarrollado con **Spring Boot** para la gestión de reservas.

##  Tecnologías utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

##  Estructura del proyecto
- controller → Controladores REST
- service → Lógica de negocio
- repository → Acceso a datos
- model / entity → Entidades JPA

##  Configuración
1. Crear la base de datos en MySQL:
```sql
CREATE DATABASE reservas_db;

Configurar application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/reservas_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

----------------------------

▶️ Ejecución del proyecto:
mvn spring-boot:run

---------------------------

URL para el navegador:
http://localhost:8080

--------------------------

🧪 Pruebas:
La API puede probarse usando Postman o Insomnia enviando y recibiendo datos en formato JSON.

{
  "cliente": "Juan Pérez",
  "fecha": "2026-01-20",
  "estado": "PENDIENTE"
}

--------------------------

Autor: Adalberto 

