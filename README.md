# Ameri - Social Network Backend 🌌

## 📌 Project Description
Ameri is a social network designed to allow users to share thoughts, interact with others, and stay connected in a dynamic and intuitive way. This backend, developed using **Spring Boot**, provides secure authentication, user management, post creation, interaction features, and a notification system.

## Features 🌐

- **Login:** Allows optimal access to the web application. It is also interactive and users will need to meet the appropriate conditions to complete the login correctly.
- **User Management:** Users will be able to register by providing: Full Name, Unique Username, Mobile Number, Unique Email, Date of Birth, Strong Password and not only this but also A user will be able to update his/her profile including: Full Name, Bio, Profile Picture, Mobile Number.
- **Publications:** Users will be able to create posts, which will include: Mandatory text, optional image (URL link), customizable tags, editing and deleting posts only by the author of the same, ordering of posts, allowing the user to choose between: chronological order and order by relevance
- **Interactions:** Users will be able to comment on posts, tag other users with @<username>, "like" posts, summary of interactions on each post, showing: total number of reactions and total number of comments.
- **User Tracking:** A user will be able to follow and unfollow others. In the home section, only posts from followed users will be displayed. Lists of: Followers and Following will be visible.
- **Notifications:** Users will receive notifications when: They receive a comment on their post, they receive a "Like" on their post, they are tagged in a post, they are followed by another user.

## 🛠️ Technologies Used
- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA (Hibernate)**
- **Spring Security with JWT Authentication**
- **PostgreSQL/MySQL**
- **Swagger (API Documentation)**
- **Maven (Dependency Management)**

## 🚀 Installation & Setup

### Prerequisites
- Java 17
- Maven 3.x
- PostgreSQL or MySQL database
- An API client like Postman or Thunder Client (optional)

### Steps to Run the Project
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/AlexisH28/Ameri
   cd Ameri
   ```

2. **Configure the Database:**
   - Open `application.properties` or `application.yml`
   - Set up your database connection:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/ameriDB
     spring.datasource.username=your_db_user
     spring.datasource.password=your_db_password
     ```

3. **Run the Application:**
   ```sh
   mvn spring-boot:run
   ```

4. **Access API Documentation:**
   - Open Swagger UI in your browser: `http://localhost:8090/swagger-ui.html`

## 🔐 Authentication & Security
- **JWT-based authentication** for secure login/logout.
- **Password hashing using BCrypt** to protect user credentials.
- **CORS configured** to allow frontend communication.
- **Role-based access control** to secure endpoints.

## 📌 API Endpoints & Usage

### 1️⃣ Authentication
| Method | Endpoint       | Description                |
|--------|--------------|----------------------------|
| POST   | `/auth/register` | Register a new user        |
| POST   | `/auth/login`    | Login and get JWT token   |

### 2️⃣ User Management
| Method | Endpoint               | Description                 |
|--------|-----------------------|-----------------------------|
| GET    | `/users/{id}`          | Get user profile            |
| PUT    | `/users/{id}`          | Update user profile         |
| GET    | `/users/{id}/followers` | Get followers of a user     |
| GET    | `/users/{id}/following` | Get users the user follows  |

### 3️⃣ Posts
| Method | Endpoint          | Description                         |
|--------|------------------|-------------------------------------|
| GET    | `/posts`          | Get all posts                      |
| GET    | `/posts/{id}`     | Get a specific post                |
| POST   | `/posts`          | Create a new post                  |
| PUT    | `/posts/{id}`     | Edit a post                        |
| DELETE | `/posts/{id}`     | Delete a post                      |

### 4️⃣ Interactions
| Method | Endpoint                     | Description                        |
|--------|-----------------------------|------------------------------------|
| POST   | `/posts/{id}/like`          | Like a post                        |
| DELETE | `/posts/{id}/unlike`        | Remove like from a post            |
| POST   | `/posts/{id}/comment`       | Add a comment to a post            |
| GET    | `/posts/{id}/comments`      | Get all comments for a post        |

### 5️⃣ Follow System
| Method | Endpoint                     | Description                        |
|--------|-----------------------------|------------------------------------|
| POST   | `/users/{id}/follow`        | Follow a user                      |
| DELETE | `/users/{id}/unfollow`      | Unfollow a user                    |

### 6️⃣ Notifications
| Method | Endpoint                     | Description                        |
|--------|-----------------------------|------------------------------------|
| GET    | `/notifications`            | Get user notifications             |

## 📌 Additional Features
- **Sorting & Filtering:** Posts can be sorted by date or relevance.
- **Mention System:** Users can tag others using `@username`.
- **Real-time Notifications:** Users get notified of likes, comments, and follows.

## 📌 Contribution
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch (`feature/new-feature`).
3. Commit your changes.
4. Push to the branch and open a Pull Request.

## 📜 License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---
> [!NOTE]
> ## Contact 🧑‍💻

Made by [Alexis Hernández](https://github.com/AlexisH28)

Alexis Rafael Hernández Tocora -- (alexismar1228@gmail.com)

## ER Diagram
![Ameri_ER](https://github.com/user-attachments/assets/71be5bf9-1323-4a64-beba-6989249b09d3)

## Demo Video
[Ameri Video](https://drive.google.com/drive/folders/1bZfq9Ye-mUwgDPPqGSx5PWl6nJ_wiUuA?usp=sharing)

## Frontend Repository
https://github.com/AlexisH28/ameri-frontend
`b588a32f3c4990e978d015061c06bd2d951cfccc`





