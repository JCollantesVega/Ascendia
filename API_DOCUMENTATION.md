# API Documentation Access

The Ascendia API uses **SpringDoc OpenAPI 3** to generate interactive API documentation.

## 📚 How to Access API Documentation

### 1. Start the Application
```bash
cd backend
mvn spring-boot:run
```

### 2. Access Documentation URLs

Once the application is running on port 8080, you can access:

- **Swagger UI (Interactive)**: http://localhost:8080/swagger-ui.html
- **Swagger UI (Alternative)**: http://localhost:8080/swagger-ui/index.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs
- **OpenAPI YAML**: http://localhost:8080/v3/api-docs.yaml

## 🔧 Configuration

### Security Configuration
The API documentation endpoints are configured to be publicly accessible in `SecurityConfig.java`:

```java
.requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
.requestMatchers("/swagger-ui.html").permitAll()
.requestMatchers("/api-docs/**").permitAll()
```

### OpenAPI Configuration
The documentation is customized in `OpenApiConfig.java` with:
- API title and description
- Contact information
- JWT Bearer authentication support
- Proper API versioning

## 🚀 Features Enabled

### 1. **Interactive API Testing**
- Try out API endpoints directly from the browser
- Test with different authentication tokens
- View request/response examples

### 2. **Comprehensive Documentation**
- All REST endpoints are documented
- Request/response schemas are automatically generated
- Validation constraints are displayed
- Security requirements are clearly marked

### 3. **JWT Authentication Support**
- Bearer token authentication is configured
- Easy to test authenticated endpoints
- Proper security documentation

## 📋 Available API Documentation

### Mentor Endpoints
- `POST /api/v1/mentors/profile` - Save/Update mentor profile
- `GET /api/v1/mentors/profile/me` - Get current user's mentor profile
- `GET /api/v1/mentors/profile/{profileId}` - Get mentor profile by ID
- `GET /api/v1/mentors/user/{userId}` - Get mentor profile by user ID

### Authentication Endpoints
- `POST /api/v1/auth/register` - User registration
- `POST /api/v1/auth/login` - User login

## 🔒 Security Notes

- All endpoints except authentication require JWT authentication
- Mentor-specific endpoints require `MENTOR` role
- API documentation is publicly accessible for development/testing
- Production deployment should consider restricting documentation access

## 🛠️ Development Tips

1. **Testing Without Authentication**: Use the swagger UI to test public endpoints first
2. **Testing With Authentication**: 
   - Log in via `/api/v1/auth/login` to get a JWT token
   - Click "Authorize" in Swagger UI and enter `Bearer <your-jwt-token>`
3. **Validation**: Request validation rules are displayed in the documentation
4. **Response Examples**: Sample responses are provided for all endpoints

## 📱 Mobile/External Access

For external integrations, use the OpenAPI specification:
- JSON: `http://localhost:8080/v3/api-docs`
- Can be used to generate client SDKs
- Compatible with tools like Postman, Insomnia, etc.