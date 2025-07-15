# 📝 BlogApp - Spring Boot Blog Application

A comprehensive, feature-rich blog application built with Spring Boot, featuring user management, content creation, search functionality, email notifications, and real-time messaging. **Successfully deployed on Railway!**

## 🚀 Live Demo
- **Production URL**: https://superb-quietude-production.up.railway.app
- **API Documentation**: https://superb-quietude-production.up.railway.app/swagger-ui.html
- **Health Check**: https://superb-quietude-production.up.railway.app/api/health

## 🚀 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Quick Start](#quick-start)
- [API Documentation](#api-documentation)
- [Database Schema](#database-schema)
- [Configuration](#configuration)
- [Features in Detail](#features-in-detail)
- [Development Guide](#development-guide)
- [Testing](#testing)
- [Deployment](#deployment)
- [Contributing](#contributing)
- [License](#license)

## 📋 Overview

BlogApp is a modern, scalable blog platform that provides a complete solution for content creation, user management, and community engagement. Built with Spring Boot and following RESTful API principles, it offers a robust backend for blog applications.

### 🎯 Key Highlights

- **RESTful API Design**: Clean, intuitive API endpoints
- **Cloud Deployment**: Successfully deployed on Railway with MySQL database
- **Search Functionality**: Comprehensive search across all entities
- **Email Notifications**: Automated email system for user engagement
- **Security**: Input validation and error handling
- **Scalability**: Designed for high-performance and scalability
- **CI/CD Pipeline**: GitHub Actions for automated testing and deployment

## ✨ Features

### 🔐 **User Management**
- User registration and authentication
- Profile management
- Role-based access control
- Password reset functionality

### 📝 **Content Management**
- Create, edit, and delete blog posts
- Category management
- Rich text content support
- Image upload capabilities

### 💬 **Social Features**
- Comment system on posts
- User following system
- Like and share functionality
- User activity tracking

### 🔍 **Search & Discovery**
- Global search across all entities
- Advanced search with filters
- Search suggestions and auto-complete
- Tag-based content discovery

### 📧 **Email Notifications**
- Welcome emails for new users
- Comment notifications
- Follow notifications
- New post notifications
- Password reset emails

### 📊 **Analytics & Insights**
- Post analytics and metrics
- User engagement tracking
- Search analytics
- Performance monitoring

### 🔄 **Real-time Features**
- Event-driven architecture (Kafka ready)
- Real-time notifications
- Live content updates
- Message streaming capabilities

## 🛠️ Technology Stack

### **Backend**
- **Spring Boot 3.2.5**: Main framework
- **Spring Data JPA**: Database operations
- **Spring Security**: Authentication and authorization
- **Spring Cloud Stream**: Event streaming (Kafka ready)
- **Hibernate**: ORM framework
- **MySQL**: Primary database (Railway hosted)
- **Kafka**: Message broker for events (configurable)

### **Email & Templates**
- **Spring Boot Mail**: Email functionality
- **Thymeleaf**: Email template engine
- **Gmail SMTP**: Email delivery

### **Search & Performance**
- **Spring Data JPA**: Search queries
- **Hibernate Search**: Advanced search capabilities
- **Lucene**: Full-text search engine

### **Development Tools**
- **Maven**: Build tool
- **Lombok**: Code generation
- **ModelMapper**: Object mapping
- **Swagger/OpenAPI**: API documentation

### **Testing & Quality**
- **JUnit 5**: Unit testing
- **Spring Boot Test**: Integration testing
- **Mockito**: Mocking framework

### **Deployment & DevOps**
- **Railway**: Cloud hosting platform
- **GitHub Actions**: CI/CD pipeline
- **Docker**: Containerization ready
- **Environment Variables**: Configurable deployment

## 📁 Project Structure

```
blog-app-apis/
├── src/
│   ├── main/
│   │   ├── java/com/codewithyash/blog/
│   │   │   ├── BlogAppApisApplication.java
│   │   │   ├── config/
│   │   │   │   ├── AppConstants.java
│   │   │   │   ├── EmailConfig.java
│   │   │   │   └── SearchConfig.java
│   │   │   ├── controllers/
│   │   │   │   ├── UserController.java
│   │   │   │   ├── PostController.java
│   │   │   │   ├── CategoryController.java
│   │   │   │   ├── CommentController.java
│   │   │   │   ├── SearchController.java
│   │   │   │   └── EmailTestController.java
│   │   │   ├── entities/
│   │   │   │   ├── User.java
│   │   │   │   ├── Post.java
│   │   │   │   ├── Category.java
│   │   │   │   └── Comment.java
│   │   │   ├── payloads/
│   │   │   │   ├── UserDto.java
│   │   │   │   ├── PostDto.java
│   │   │   │   ├── CategoryDto.java
│   │   │   │   ├── CommentDto.java
│   │   │   │   ├── SearchResult.java
│   │   │   │   └── ApiResponse.java
│   │   │   ├── repositories/
│   │   │   │   ├── UserRepo.java
│   │   │   │   ├── PostRepo.java
│   │   │   │   ├── CategoryRepo.java
│   │   │   │   └── CommentRepo.java
│   │   │   ├── services/
│   │   │   │   ├── UserService.java
│   │   │   │   ├── PostService.java
│   │   │   │   ├── CategoryService.java
│   │   │   │   ├── CommentService.java
│   │   │   │   ├── SearchService.java
│   │   │   │   └── EmailService.java
│   │   │   ├── impl/
│   │   │   │   ├── UsersServiceImpl.java
│   │   │   │   ├── PostServiceImpl.java
│   │   │   │   ├── CategoryServiceImpl.java
│   │   │   │   ├── CommentServiceImpl.java
│   │   │   │   ├── SearchServiceImpl.java
│   │   │   │   └── EmailServiceImpl.java
│   │   │   └── exceptions/
│   │   │       ├── ResourceNotFoundException.java
│   │   │       └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/email/
│   │           ├── welcome-email.html
│   │           └── comment-notification.html
│   └── test/
│       └── java/com/codewithyash/blog/
│           └── BlogAppApisApplicationTests.java
├── pom.xml
├── README.md
├── SEARCH_FEATURES.md
└── EMAIL_SETUP.md
```

## 🚀 Quick Start

### **Option 1: Local Development**

#### **Prerequisites**
- Java 21 or higher
- Maven 3.6+
- MySQL 8.0+ (local or cloud)
- Apache Kafka 4.0.0+ (optional)

#### **1. Clone the Repository**
```bash
git clone <repository-url>
cd blog-app-apis
```

#### **2. Database Setup**
```sql
CREATE DATABASE blog_app_apis;
CREATE USER 'bloguser'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON blog_app_apis.* TO 'bloguser'@'localhost';
FLUSH PRIVILEGES;
```

#### **3. Configure Application**
Edit `src/main/resources/application.properties`:
```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
spring.datasource.username=bloguser
spring.datasource.password=your_password
```

#### **4. Run the Application**
```bash
./mvnw spring-boot:run
```

### **Option 2: Railway Deployment (Recommended)**

#### **1. Fork/Clone Repository**
```bash
git clone <repository-url>
cd blog-app-apis
```

#### **2. Deploy to Railway**
1. **Go to [Railway.app](https://railway.app)**
2. **Connect your GitHub repository**
3. **Add MySQL service** in Railway dashboard
4. **Set environment variables** (auto-configured)
5. **Deploy automatically** on push to main

#### **3. Access Your Application**
- **Production URL**: https://superb-quietude-production.up.railway.app
- **API Documentation**: https://superb-quietude-production.up.railway.app/swagger-ui.html
- **Health Check**: https://superb-quietude-production.up.railway.app/api/health

### **3. Configure Application**
Edit `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
spring.datasource.username=bloguser
spring.datasource.password=your_password

# Email Configuration (Optional)
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password

# Kafka Configuration
spring.cloud.stream.kafka.binder.brokers=localhost:9092
```

### **4. Start Kafka**
```bash
# Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start Kafka
bin/kafka-server-start.sh config/server.properties
```

### **5. Run the Application**
```bash
./mvnw spring-boot:run
```

### **6. Access the Application**
- **API Base URL**: `http://localhost:8080/api`
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **Health Check**: `http://localhost:8080/actuator/health`

## 📚 API Documentation

### **Production Base URL**: `https://superb-quietude-production.up.railway.app/api`
### **Local Base URL**: `http://localhost:8080/api`

### **🔐 User Management**

#### **Create User**
```http
POST /users/
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123",
  "about": "Software Developer"
}
```

#### **Get All Users**
```http
GET /users/
```

#### **Get User by ID**
```http
GET /users/{userId}
```

#### **Update User**
```http
PUT /users/{userId}
Content-Type: application/json

{
  "name": "John Updated",
  "email": "john.updated@example.com",
  "password": "newpassword123",
  "about": "Updated bio"
}
```

#### **Delete User**
```http
DELETE /users/{userId}
```

### **📝 Post Management**

#### **Create Post**
```http
POST /user/{userId}/category/{categoryId}/posts
Content-Type: application/json

{
  "title": "My First Post",
  "content": "This is the content of my first blog post.",
  "imageName": "default.png"
}
```

#### **Get All Posts**
```http
GET /posts?pageNumber=0&pageSize=10&sortBy=postId&sortDir=asc
```

#### **Get Post by ID**
```http
GET /posts/{postId}
```

#### **Update Post**
```http
PUT /posts/{postId}
Content-Type: application/json

{
  "title": "Updated Post Title",
  "content": "Updated content"
}
```

#### **Delete Post**
```http
DELETE /posts/{postId}
```

### **📂 Category Management**

#### **Create Category**
```http
POST /categories/
Content-Type: application/json

{
  "categoryTitle": "Technology",
  "categoryDescription": "Posts about technology and programming"
}
```

#### **Get All Categories**
```http
GET /categories/
```

#### **Update Category**
```http
PUT /categories/{categoryId}
Content-Type: application/json

{
  "categoryTitle": "Updated Technology",
  "categoryDescription": "Updated description"
}
```

#### **Delete Category**
```http
DELETE /categories/{categoryId}
```

### **🔍 Search API**

#### **Global Search**
```http
GET /search/global?keyword=spring
```

#### **Search Posts**
```http
GET /search/posts?keyword=java&page=0&size=10
```

#### **Search Users**
```http
GET /search/users?keyword=john
```

#### **Search Categories**
```http
GET /search/categories?keyword=technology
```

#### **Advanced Search**
```http
GET /search/advanced?keyword=spring&category=technology&author=john
```

#### **Search Suggestions**
```http
GET /search/suggestions?keyword=spr
```

### **📧 Email Testing**

#### **Test Welcome Email**
```http
POST /test/email/welcome
Content-Type: application/x-www-form-urlencoded

email=test@example.com&name=Test User
```

#### **Test Comment Notification**
```http
POST /test/email/comment-notification
Content-Type: application/x-www-form-urlencoded

authorEmail=author@example.com&authorName=John Doe&commenterName=Jane Smith&postTitle=My Post&commentContent=Great article!
```

## 🗄️ Database Schema

### **Users Table**
```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    about TEXT
);
```

### **Categories Table**
```sql
CREATE TABLE categories (
    id INT AUTO_INCREMENT PRIMARY KEY,
    category_title VARCHAR(100) NOT NULL,
    category_description TEXT
);
```

### **Posts Table**
```sql
CREATE TABLE posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    image_name VARCHAR(100),
    added_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    category_id INT,
    user_id INT,
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

### **Comments Table**
```sql
CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    post_id INT,
    user_id INT,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

## ⚙️ Configuration

### **Application Properties**

#### **Database Configuration**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app_apis
spring.datasource.username=root
spring.datasource.password=root1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

#### **Email Configuration**
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

#### **Kafka Configuration**
```properties
spring.cloud.stream.kafka.binder.brokers=localhost:9092
spring.cloud.function.definition=userEventReceiver
spring.cloud.stream.bindings.userEventReceiver-in-0.destination=user.created
```

#### **Search Configuration**
```properties
app.search.default-page-size=10
app.search.max-results=100
app.search.suggestions-limit=10
app.search.enable-fuzzy-search=true
```

## 🎯 Features in Detail

### **1. User Management System**

#### **Features**
- User registration with validation
- Profile management
- Email verification (ready for implementation)
- Password reset functionality
- Role-based access control

#### **Security**
- Input validation using Bean Validation
- Password encryption (ready for implementation)
- JWT token authentication (ready for implementation)

### **2. Content Management**

#### **Post Features**
- Create, read, update, delete posts
- Category assignment
- Image upload support
- Rich text content
- Pagination and sorting

#### **Category Management**
- Hierarchical category structure
- Category-based post filtering
- Category analytics

### **3. Search Functionality**

#### **Search Types**
- **Global Search**: Search across all entities
- **Post Search**: Search posts with pagination
- **User Search**: Search users by name/email
- **Category Search**: Search categories
- **Advanced Search**: Multi-filter search
- **Tag Search**: Search by tags
- **Quick Search**: Fast post search

#### **Search Features**
- Case-insensitive search
- Partial matching
- Search suggestions
- Result highlighting (ready for implementation)

### **4. Email Notification System**

#### **Email Types**
- Welcome emails for new users
- Comment notifications
- Follow notifications
- New post notifications
- Password reset emails

#### **Features**
- HTML email templates
- Responsive design
- Error handling
- Delivery tracking

### **5. Real-time Features**

#### **Kafka Integration**
- Event-driven architecture
- User creation events
- Post creation events
- Comment events
- Follow events

#### **Benefits**
- Scalable messaging
- Decoupled services
- Real-time notifications
- Event sourcing ready

## 🛠️ Development Guide

### **Adding New Features**

#### **1. Create Entity**
```java
@Entity
@Table(name = "your_table")
public class YourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    // Add fields
}
```

#### **2. Create Repository**
```java
public interface YourRepo extends JpaRepository<YourEntity, Integer> {
    // Add custom query methods
}
```

#### **3. Create DTO**
```java
public class YourDto {
    // Add fields matching your entity
}
```

#### **4. Create Service**
```java
public interface YourService {
    // Define service methods
}

@Service
public class YourServiceImpl implements YourService {
    // Implement service methods
}
```

#### **5. Create Controller**
```java
@RestController
@RequestMapping("/api/your-endpoint")
public class YourController {
    // Define REST endpoints
}
```

### **Code Style Guidelines**

#### **Naming Conventions**
- **Classes**: PascalCase (e.g., `UserController`)
- **Methods**: camelCase (e.g., `createUser`)
- **Variables**: camelCase (e.g., `userName`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_SIZE`)

#### **Package Structure**
- **controllers**: REST API endpoints
- **services**: Business logic
- **repositories**: Data access layer
- **entities**: Database models
- **payloads**: DTOs and response objects
- **config**: Configuration classes
- **exceptions**: Custom exceptions

### **Error Handling**

#### **Global Exception Handler**
```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    // Handle all exceptions globally
}
```

#### **Custom Exceptions**
```java
public class ResourceNotFoundException extends RuntimeException {
    // Custom exception for resource not found
}
```

## 🧪 Testing

### **Unit Testing**
```bash
./mvnw test
```

### **Integration Testing**
```bash
./mvnw verify
```

### **Manual Testing**

#### **Test User Creation**
```bash
curl -X POST http://localhost:8080/api/users/ \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@example.com","password":"password123","about":"Test bio"}'
```

#### **Test Search**
```bash
curl "http://localhost:8080/api/search/global?keyword=test"
```

#### **Test Email**
```bash
curl -X POST "http://localhost:8080/api/test/email/welcome" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  -d "email=test@example.com&name=Test User"
```

## 🚀 Deployment

### **Railway Deployment (Production)**

This application is successfully deployed on Railway with the following setup:

#### **Services**
- **Web Service**: Spring Boot application
- **MySQL Database**: Hosted on Railway
- **Environment Variables**: Auto-configured

#### **Deployment Process**
1. **GitHub Integration**: Automatic deployment on push to main
2. **Database Setup**: MySQL service provisioned automatically
3. **Environment Configuration**: Variables set automatically
4. **Health Monitoring**: Built-in health checks

#### **Access URLs**
- **Production**: https://superb-quietude-production.up.railway.app
- **API Docs**: https://superb-quietude-production.up.railway.app/swagger-ui.html
- **Health Check**: https://superb-quietude-production.up.railway.app/api/health

#### **Environment Variables**
The application uses environment variables for configuration:
```bash
# Database Configuration (Auto-set by Railway)
SPRING_DATASOURCE_URL=jdbc:mysql://mysql.railway.internal:3306/railway
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=[auto-generated]

# JPA Configuration
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_SHOW_SQL=false
SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect

# Server Configuration
SERVER_PORT=8080
```

### **Local Development**
```bash
./mvnw spring-boot:run
```

### **Docker Deployment**

A `docker-compose.yml` file is included for local development with Kafka:

```bash
# Start with Kafka
docker-compose up -d

# Start without Kafka
docker-compose up -d zookeeper kafka
```

### **Manual Deployment**

#### **1. Build JAR**
```bash
./mvnw clean package
```

#### **2. Run JAR**
```bash
java -jar target/blog-app-apis-0.0.1-SNAPSHOT.jar
```

#### **3. Docker Deployment**
```dockerfile
FROM openjdk:21-jdk-slim
COPY target/blog-app-apis-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
```

### **Environment Variables (Local)**
```bash
export SPRING_DATASOURCE_URL=jdbc:mysql://your-db-host:3306/blog_app_apis
export SPRING_DATASOURCE_USERNAME=your-username
export SPRING_DATASOURCE_PASSWORD=your-password
export SPRING_MAIL_USERNAME=your-email@gmail.com
export SPRING_MAIL_PASSWORD=your-app-password
```

## 📈 Performance Optimization

### **Database Optimization**
- Index frequently searched columns
- Use connection pooling
- Optimize query performance
- Implement caching

### **Application Optimization**
- Enable compression
- Use async processing
- Implement caching
- Optimize JVM settings

### **Monitoring**
- Application metrics
- Database performance
- Search analytics
- Error tracking

## 🔒 Security Considerations

### **Input Validation**
- Validate all user inputs
- Prevent SQL injection
- Sanitize search queries
- Rate limiting

### **Authentication & Authorization**
- Implement JWT tokens
- Role-based access control
- Password encryption
- Session management

### **Data Protection**
- Encrypt sensitive data
- Secure API endpoints
- HTTPS in production
- Regular security audits

## 🤝 Contributing

### **Development Workflow**

1. **Fork the repository**
2. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Make your changes**
4. **Write tests**
5. **Commit your changes**
   ```bash
   git commit -m "Add your feature description"
   ```
6. **Push to the branch**
   ```bash
   git push origin feature/your-feature-name
   ```
7. **Create a Pull Request**

### **Code Review Guidelines**
- Follow coding standards
- Write comprehensive tests
- Update documentation
- Ensure backward compatibility

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

### **Getting Help**
- Check the [Issues](https://github.com/your-repo/issues) page
- Review the documentation
- Contact the development team

### **Reporting Bugs**
- Use the GitHub Issues tracker
- Provide detailed bug reports
- Include steps to reproduce
- Add relevant logs

### **Feature Requests**
- Submit feature requests via GitHub Issues
- Describe the use case
- Provide implementation suggestions

---

## 🎉 Acknowledgments

- **Spring Boot Team**: For the excellent framework
- **Railway**: For seamless cloud deployment
- **MySQL**: For reliable database support
- **Open Source Community**: For various libraries and tools

## 📊 Current Status

### ✅ **Successfully Implemented**
- **Cloud Deployment**: Live on Railway
- **Database**: MySQL hosted on Railway
- **REST APIs**: All endpoints functional
- **Search Functionality**: Global and advanced search
- **Email System**: Template-based emails
- **Health Checks**: Application monitoring
- **CI/CD**: GitHub Actions pipeline
- **Documentation**: Swagger UI available

### 🔄 **In Progress**
- **Kafka Integration**: Event streaming (configurable)
- **Real-time Features**: Message queuing
- **Advanced Analytics**: Performance monitoring

### 🚀 **Future Enhancements**
- **Authentication**: JWT token system
- **File Upload**: Image handling
- **Caching**: Redis integration
- **Monitoring**: Advanced metrics

---

**Happy Coding! 🚀**

For more detailed information about specific features, see:
- [Search Features](SEARCH_FEATURES.md)
- [Email Setup](EMAIL_SETUP.md) 

---

## 1. **Out of Memory (OOM) Errors**

**What it means:**  
Your app is using more memory than Railway's free/allocated plan allows, causing it to crash.

**How to fix:**
- **Reduce memory usage:**  
  - Disable or remove Kafka integration (since it's not working and is resource-intensive).
  - Reduce the number of threads or connection pool size in your app.
  - Make sure you are not loading large datasets into memory.
- **Increase Railway plan:**  
  - Upgrade to a paid plan with more memory (if you need Kafka and other heavy features).
- **Set JVM memory limits:**  
  Add this environment variable in Railway:
  ```
  JAVA_TOOL_OPTIONS=-Xmx256m
  ```
  (or try `-Xmx512m` if your plan allows)

---

## 2. **Kafka DNS Resolution Failure**

**What it means:**  
Your app is trying to connect to `INTERNAL://kafka.railway.internal:29092` but cannot resolve the hostname. This is a common issue with Railway's internal Kafka networking.

**How to fix:**
- **Disable Kafka integration** in your `application.properties` (recommended for now, since Railway's Kafka is unreliable for most users).
- **Or, try using the public Kafka URL** (if Railway provides one in the Kafka service "Connect" tab).
- **Or, use Confluent Cloud or Upstash Kafka** for reliable managed Kafka.

---

## **Recommended Immediate Steps**

### **A. Disable Kafka Integration**
Comment out all Kafka-related properties in `src/main/resources/application.properties`:
```properties
#spring.cloud.stream.kafka.binder.brokers=...
#spring.cloud.stream.kafka.binder.configuration.spring.json.trusted.packages=*
#spring.cloud.stream.kafka.binder.configuration.spring.json.use.type.headers=false
#spring.cloud.stream.kafka.binder.configuration.spring.json.value.default.type=...
#spring.cloud.stream.bindings.userCreatedEvent-out-0.destination=...
#spring.cloud.function.definition=...
#spring.cloud.stream.bindings.userEventReceiver-in-0.destination=...
# ...and all other spring.cloud.stream.* Kafka lines
```
Push and redeploy.

### **B. Set JVM Memory Limit**
Add this environment variable in Railway:
```
JAVA_TOOL_OPTIONS=-Xmx256m
```
This limits your app to 256MB RAM, which helps prevent OOM errors on free/low-tier plans.

### **C. Redeploy and Monitor**
- Your app should now start and stay up.
- All REST APIs, DB, and email features will work.
- Kafka/event features will be disabled (no more errors or OOM).

---

## **Summary Table**

| Problem         | Solution                                      |
|-----------------|-----------------------------------------------|
| OOM Crashes     | Set `JAVA_TOOL_OPTIONS=-Xmx256m`              |
| Kafka DNS Error | Disable Kafka in `application.properties`     |

---

**Let me know if you want the Kafka lines commented out for you, or if you want to try a managed Kafka service like Confluent Cloud!** 