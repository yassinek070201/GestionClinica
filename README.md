# Sistema de Gestión de Clínica

Aplicación de gestión clínica desarrollada en **Java** para administrar pacientes, profesionales médicos y citas. El sistema incorpora diferentes tipos de agendas y mecanismos de persistencia mediante archivos **CSV, DAT y XML**.

El proyecto está diseñado siguiendo los principios de la **Programación Orientada a Objetos**, con una arquitectura modular que separa las entidades, la gestión de agendas y la persistencia de datos.

---

## Descripción

El sistema permite gestionar el funcionamiento básico de una clínica desde una interfaz de consola.

Entre sus principales funcionalidades se encuentran:

- Gestión de pacientes.
- Gestión de médicos y especialidades.
- Creación y administración de citas.
- Gestión de diferentes tipos de agenda.
- Gestión de citas de urgencias mediante prioridades.
- Actualización y cancelación de citas.
- Consulta de pacientes, médicos y citas.
- Persistencia de información en diferentes formatos.
- Recuperación de información almacenada entre ejecuciones.

El diseño del sistema busca mantener separadas las responsabilidades de cada componente, facilitando su mantenimiento y posible evolución hacia una aplicación con interfaz gráfica o arquitectura cliente-servidor.

---

## Funcionalidades

### Gestión de pacientes

El sistema permite:

- Registrar nuevos pacientes.
- Asignar identificadores únicos.
- Registrar la fecha de nacimiento.
- Consultar los pacientes registrados.
- Persistir la información mediante archivos CSV.
- Recuperar los pacientes almacenados.

### Gestión de médicos

Cada médico dispone de:

- Identificador único.
- Nombre.
- Especialidad médica.

Las especialidades contempladas actualmente son:

- Medicina general
- Otorrinolaringología
- Cirugía
- Pediatría
- Oftalmología

La información de los médicos puede almacenarse y recuperarse mediante archivos CSV.

### Gestión de citas

Las citas permiten relacionar pacientes y médicos junto con una fecha y una prioridad determinada.

El sistema contempla diferentes modalidades:

```text
GENERAL
ESPECIALISTA
URGENCIAS

```

Las citas pueden disponer de diferentes niveles de prioridad:

```text
BAJA
MEDIA
ALTA

```

Esto permite gestionar de forma diferenciada las consultas habituales, las citas con especialistas y las situaciones de urgencia.

---

## Persistencia de datos

El proyecto implementa diferentes mecanismos de persistencia dependiendo del tipo de información.

### CSV

Los archivos CSV se utilizan para almacenar información relacionada con:

- Pacientes.
- Médicos.
- Agenda general.

Esto permite trabajar con datos estructurados de forma sencilla y fácilmente legible.

### DAT

Las citas de especialistas utilizan persistencia mediante archivos binarios:

```text
AgendaEspecialista.dat

```

Este sistema permite almacenar y recuperar objetos utilizando mecanismos de persistencia binaria de Java.

### XML

Las citas de urgencias se almacenan mediante XML:

```text
AgendaUrgencias.xml

```

La aplicación utiliza las APIs estándar de Java para generar y procesar documentos XML mediante DOM.

---

## Arquitectura del proyecto

El código se encuentra organizado en diferentes paquetes según la responsabilidad de cada componente:

```text
src/
│
├── ClaseClinica/
│   └── Clinica.java
│
├── ClasesAgendas/
│   ├── AgendaCSV.java
│   ├── AgendaDAT.java
│   ├── AgendaGeneral.java
│   ├── AgendaXML.java
│   ├── Comparator.java
│   └── TipoAgenda.java
│
├── ClasesCitas/
│   ├── Cita.java
│   ├── CitaEspecialista.java
│   ├── CitaGeneral.java
│   ├── CitaUrgencias.java
│   ├── ContadoresCSV.java
│   └── Prioridad.java
│
├── ClasesPersonas/
│   ├── Especialidad.java
│   ├── Medicos.java
│   ├── MedicosCSV.java
│   ├── Pacientes.java
│   └── PacientesCSV.java
│
└── Main.java

```


**`Clinic`**

Actúa como componente central del sistema y coordina la gestión de pacientes, médicos y citas.

**`Appointment`**

Representa una cita médica y contiene la información necesaria para relacionar paciente, médico, fecha, prioridad y tipo de cita.

**`GeneralAppointment`****,** **`SpecialistAppointment`** **y** **`EmergencyAppointment`**

Especializan el comportamiento de los diferentes tipos de citas mediante herencia.

**`GeneralSchedule`**

Gestiona las colecciones de citas y proporciona operaciones relacionadas con su administración.

**`CsvSchedule`****,** **`DatSchedule`** **y** **`XmlSchedule`**

Se encargan de implementar los diferentes mecanismos de persistencia.

**`Patient`** **y** **`Doctor`**

Representan las principales entidades del dominio de la aplicación.

---

## Conceptos de programación aplicados

Durante el desarrollo se han utilizado diferentes conceptos fundamentales de Java:

- Programación Orientada a Objetos.
- Encapsulación.
- Herencia.
- Polimorfismo.
- Enumeraciones (`enum`).
- Clases y objetos.
- Colecciones mediante `List` y `ArrayList`.
- Constructores y sobrecarga.
- Métodos estáticos.
- Gestión de fechas mediante `LocalDate`.
- Entrada de datos mediante `Scanner`.
- Manejo de excepciones.
- Lectura y escritura de archivos.
- Persistencia binaria.
- Procesamiento de archivos CSV.
- Procesamiento de documentos XML.
- Comparación y ordenación de objetos.
- Gestión de prioridades.

---

## Estructura de datos

La aplicación utiliza principalmente colecciones de Java para gestionar las entidades durante la ejecución:

```java
List<Patient>
List<Doctor>
List<Appointment>

```

Estas estructuras permiten añadir, consultar, modificar y eliminar elementos de forma dinámica.

La información se mantiene posteriormente mediante los diferentes sistemas de persistencia implementados.

---

## Tecnologías utilizadas

| TecnologíaUso               |                                     |
| --------------------------- | ----------------------------------- |
| Java                        | Lenguaje principal                  |
| Object-Oriented Programming | Diseño y arquitectura               |
| Java Collections            | Gestión de entidades y citas        |
| LocalDate                   | Gestión de fechas                   |
| CSV                         | Persistencia de datos estructurados |
| DAT                         | Persistencia binaria                |
| XML / DOM                   | Persistencia y procesamiento XML    |
| Scanner                     | Interacción con el usuario          |
| NetBeans                    | Entorno de desarrollo               |

---

## Ejecución

### Requisitos

- **Java JDK 23** o compatible.
- NetBeans u otro IDE compatible con proyectos Java.
- No requiere dependencias externas.

### Ejecución desde un IDE

1. Clonar el repositorio.
2. Abrir el proyecto en el IDE.
3. Configurar un JDK compatible.
4. Ejecutar la clase principal `Main`.

### Ejecución desde consola

Compilar el proyecto:

```bash
javac -d build/classes $(find src -name "*.java")

```

Ejecutar la aplicación:

```bash
java -cp build/classes Main

```

> El comando de compilación puede variar dependiendo del sistema operativo y de la terminal utilizada.

---

## Interfaz de usuario

La aplicación utiliza actualmente una interfaz basada en consola.

El menú principal permite acceder a las diferentes operaciones del sistema:

```text
1. Registrar paciente
2. Registrar médico
3. Consultar pacientes
4. Consultar médicos
5. Crear cita
6. Actualizar cita
7. Cancelar cita
8. Gestionar siguiente cita
9. Consultar citas
0. Salir

```

La interfaz está diseñada para proporcionar un flujo sencillo de interacción con las diferentes funcionalidades de la aplicación.

---

## Persistencia

Los principales archivos utilizados por la aplicación son:

```text
AgendaEspecialista.dat
AgendaGeneral.csv
AgendaUrgencias.xml
medicos.csv
pacientes.csv

```

Estos archivos permiten mantener los datos entre diferentes ejecuciones de la aplicación.

---

## Posibles mejoras

El proyecto puede evolucionar hacia una aplicación de gestión clínica más completa mediante diferentes mejoras:

- Implementación de una interfaz gráfica con JavaFX.
- Migración de la persistencia basada en archivos a una base de datos relacional.
- Integración con MySQL o PostgreSQL.
- Implementación de un sistema de autenticación.
- Gestión de usuarios y roles.
- Validación avanzada de datos.
- Búsqueda y filtrado de pacientes y médicos.
- Gestión de horarios y disponibilidad.
- Historial de citas por paciente.
- Tests automatizados mediante JUnit.
- Implementación de una API REST.
- Separación del sistema en capas.
- Aplicación de patrones de diseño.
- Documentación mediante Javadoc.

---

## Objetivos técnicos

Este proyecto demuestra la aplicación práctica de conceptos fundamentales del desarrollo de software con Java:

- Diseño de aplicaciones orientadas a objetos.
- Modelado de entidades y relaciones.
- Organización modular del código.
- Gestión de colecciones.
- Herencia y polimorfismo.
- Tratamiento de fechas y prioridades.
- Persistencia de información.
- Procesamiento de diferentes formatos de datos.
- Manejo de excepciones.
- Diseño de un sistema preparado para futuras ampliaciones.

---

## Roadmap

Las posibles líneas de evolución del proyecto incluyen:

```text
[x] Gestión de pacientes
[x] Gestión de médicos
[x] Gestión de citas
[x] Gestión de prioridades
[x] Persistencia CSV
[x] Persistencia binaria
[x] Persistencia XML
[ ] Interfaz gráfica
[ ] Base de datos
[ ] API REST
[ ] Autenticación y autorización
[ ] Tests automatizados

```

---

## Autor

Proyecto desarrollado como parte de mi portfolio de desarrollo de software, mostrando conocimientos prácticos en **Java, Programación Orientada a Objetos, estructuras de datos y persistencia de información**.
