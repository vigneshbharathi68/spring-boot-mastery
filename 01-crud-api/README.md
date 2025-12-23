01-CRUD-API: Project Plan 🎯
📊 Database Schema (2 Tables)
1. User Table
sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INT CHECK (age >= 18),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
2. Book Table (with User Foreign Key)
sql
CREATE TABLE books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(200) NOT NULL,
    isbn VARCHAR(20) UNIQUE NOT NULL,
    author VARCHAR(100) NOT NULL,
    user_id BIGINT,
    published_year INT,
    available BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
🔗 REST Endpoints (Complete CRUD)
Users API
text
GET     /api/users              → All users (paginated)
GET     /api/users/{id}         → Single user by ID
POST    /api/users              → Create user
PUT     /api/users/{id}         → Update user
DELETE  /api/users/{id}         → Delete user
GET     /api/users/search       → Search by name/email
Books API
text
GET     /api/books              → All books (paginated)
GET     /api/books/{id}         → Single book by ID
POST    /api/books              → Create book
PUT     /api/books/{id}         → Update book
DELETE  /api/books/{id}         → Delete book
GET     /api/books/user/{userId}→ Books by user
GET     /api/books/available    → Available books only
📋 Sample Payloads
Create User (POST)
json
{
    "name": "John Doe",
    "email": "john@example.com",
    "age": 28
}
Create Book (POST)
json
{
    "title": "Spring Boot Mastery",
    "isbn": "978-1234567890",
    "author": "Vignesh Bharathi",
    "userId": 1,
    "publishedYear": 2025,
    "available": true
}
⚙️ Tech Stack
text
✅ Spring Boot 3.x + JPA + H2 (dev) + PostgreSQL (prod)
✅ @RestController | @Service | @Repository
✅ @Valid + Bean Validation
✅ Global Exception Handler (@ControllerAdvice)
✅ Pagination (Pageable)
✅ OpenAPI/Swagger docs
✅ Docker ready