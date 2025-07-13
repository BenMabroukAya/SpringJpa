
# SpringJpa

A Spring Boot 3 application using Spring Data JPA to demonstrate CRUD operations on JPA entities with a relational database.

---

## 🚀 Features

- **CRUD operations** using Spring Data JPA repositories  
- **Entity mapping** with JPA and Hibernate  
- **REST API endpoints** for managing domain entities  
- **Database persistence** (e.g., H2, MySQL, PostgreSQL — configurable)  
- **Swagger/OpenAPI** for interactive API documentation (if included)  
- **Tests**: integration & unit tests using JUnit and Mockito  

---

## 📦 Requirements

- Java 17+
- Maven 3.8+
- A supported database (default: in-memory H2)
- Optional: Docker and Docker Compose for containerized DB

---

## ⏩ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/BenMabroukAya/SpringJpa.git
cd SpringJpa
````

### 2. Configuration

Edit `src/main/resources/application.yml` or `.properties` to configure:

* **spring.datasource.url** – database URL
* **spring.datasource.username** and **password**
* **spring.jpa.hibernate.ddl-auto** – `create`, `update`, or `validate`

Default setup uses H2 in-memory database.

### 3. Run the App

```bash
./mvnw spring-boot:run
```

The app runs on `http://localhost:8080`.

### 4. API Exploration

* Swagger UI (if available): `http://localhost:8080/swagger-ui.html`
* H2 console: `http://localhost:8080/h2-console`

Sample API usage (replace `entity` with your domain model):

```bash
# Create
curl -X POST -H "Content-Type: application/json" \
  -d '{"name":"Sample"}' http://localhost:8080/api/entities

# Read
curl http://localhost:8080/api/entities/1

# Update
curl -X PUT -H "Content-Type: application/json" \
  -d '{"name":"Updated"}' http://localhost:8080/api/entities/1

# Delete
curl -X DELETE http://localhost:8080/api/entities/1
```

---

## 🧪 Testing

```bash
./mvnw test
```

* **Unit tests** cover service & repository layers.
* **Integration tests** run against H2 by default.

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/com/example/
    │   ├── controller/      ← REST controllers
    │   ├── service/         ← Business logic
    │   ├── repository/      ← JPA repository interfaces
    │   └── model/           ← JPA entity classes
    └── resources/
        ├── application.yml
        ├── data.sql         ← (Optional) Initial test data
        └── schema.sql       ← (Optional) Custom DDL scripts
```

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the project
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes
4. Push to your branch
5. Create a Pull Request

Please abide by code style, add tests, and document new features.

---

## 📚 Resources & Help

* [Spring Boot documentation](https://spring.io/projects/spring-boot)
* [Spring Data JPA reference](https://spring.io/projects/spring-data-jpa)
* Raise any issues via this repository's "Issues" tab.

---

## 📝 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

---

## ✉️ Author

**Ben Mabrouk Aya**

* GitHub: [@BenMabroukAya](https://github.com/BenMabroukAya)
* Feel free to connect for questions, feedback, or collaboration!

