# springsetup

Basic Spring Boot REST API.

## Run

```bash
./mvnw spring-boot:run
```

## Endpoints

| Method | Path              | Description      |
|--------|-------------------|------------------|
| GET    | /api/hello?name=X | Greeting         |
| GET    | /api/items        | List items       |
| GET    | /api/items/{id}   | Get item         |
| POST   | /api/items        | Create item      |
| PUT    | /api/items/{id}   | Update item      |
| DELETE | /api/items/{id}   | Delete item      |

```bash
curl -X POST localhost:8080/api/items -H "Content-Type: application/json" -d '{"name":"Book","description":"A good one"}'
```
