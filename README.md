# TPNº4 - Implementación de ENVERS

## Descripción

Este proyecto es una aplicación de gestión de artículos y su venta a clientes, desarrollada con Spring Boot y Hibernate. Utiliza Hibernate Envers para implementar auditoría, lo que permite realizar un seguimiento de los cambios en las entidades del sistema.

## Dependencias

El proyecto utiliza las siguientes dependencias:

- `org.springframework.boot:spring-boot-starter-data-jpa`
- `org.springframework.boot:spring-boot-starter-data-rest`
- `org.springframework.boot:spring-boot-starter-web`
- `org.projectlombok:lombok`
- `org.springframework.boot:spring-boot-devtools`
- `com.h2database:h2`
- `org.hibernate.orm:hibernate-envers:6.5.2.Final`
- `org.springframework.boot:spring-boot-starter-test`
- `org.junit.platform:junit-platform-launcher`

### Nota sobre Hibernate Envers

Se ha agregado `org.hibernate.orm:hibernate-envers:6.5.2.Final` debido a problemas de compatibilidad con versiones anteriores de Hibernate Envers y la versión de Spring Boot utilizada. Esta versión de Envers es compatible con el proyecto y permite realizar auditoría en las entidades.

## Configuración

1. **Configuración de la base de datos**: 
   - La base de datos utilizada en el proyecto es H2 en modo memoria para pruebas y desarrollo.
   - La configuración se realiza a través de las propiedades de Spring Boot en el archivo `application.properties`.

2. **Auditoría con Hibernate Envers**:
   - La auditoría se configura en el proyecto mediante Hibernate Envers. Esta biblioteca permite rastrear los cambios en las entidades a lo largo del tiempo.
   - Se deben añadir anotaciones y configuraciones específicas en las entidades para habilitar la auditoría.

## Ejecución

1. **Compilación y Ejecución**:
   - El proyecto se compila y ejecuta utilizando Gradle. Asegúrate de tener Gradle instalado.
   - Ejecuta el siguiente comando para construir el proyecto:
     ```bash
     ./gradlew build
     ```
   - Para ejecutar la aplicación, utiliza el comando:
     ```bash
     ./gradlew bootRun
     ```

2. **Acceso a la Aplicación**:
   - Una vez que la aplicación esté en ejecución, estará disponible en `http://localhost:8080/h2-console`.
   
## Implementación de Auditoría

- **Configuración de Envers**: La configuración para habilitar Envers se encuentra en el archivo de configuración de Spring Boot y en las entidades correspondientes.
- **Anotaciones**: Se deben utilizar las anotaciones `@Audited` en las entidades que se desean auditar.
- **Tablas de Auditoría**: Envers crea automáticamente tablas de auditoría para registrar los cambios en las entidades.




