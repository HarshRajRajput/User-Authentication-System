# User Authentication System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Servlet](https://img.shields.io/badge/Servlets%2FJSP-4285F4?style=for-the-badge&logo=apache&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Tomcat](https://img.shields.io/badge/Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)
![Made with Love](https://img.shields.io/badge/Made%20with-%E2%9D%A4-red?style=for-the-badge)

A **Java Servlet & JSP-based Dynamic Web Project** that provides user authentication features such as **registration, login, logout, and password update**.  

---

## 🚀 Features

- **User Registration** – Create an account with full name, email, and password.  
- **User Login** – Login with credentials and start a session.  
- **Password Update** – Change password securely using email.  
- **Logout** – Ends session and prevents cached access.  
- **Error Handling** – User-friendly error pages for invalid login, registration failure, and password errors.  
- **Responsive UI** – Styled with CSS for better user experience.  

---

## 📂 Project Structure

```text
user-authentication-system/
├── Java Resources/
│   └── src/main/java/com/tech/
│       ├── UserLoginServlet.java
│       ├── UserRegistrationServlet.java
│       └── UserUpdatePassword.java
│
├── src/main/webapp/
│   ├── META-INF/
│   ├── WEB-INF/                          # web.xml (deployment descriptor)
│   ├── error.html
│   ├── error-styles.css
│   ├── home.jsp
│   ├── home-styles.css
│   ├── index.jsp
│   ├── index-styles.css
│   ├── login.jsp
│   ├── login-styles.css
│   ├── logout.jsp
│   ├── logout-styles.css
│   ├── registration.html
│   ├── registration-styles.css
│   ├── registrationSucces.html
│   ├── registrationSucces.css
│   ├── updatePassword.html
│   ├── updatePasswordError.html
│   ├── updatePasswordError-styles.css
│   ├── updatePassword-styles.css
│   ├── updatePasswordSucces.html
│   └── updatePasswordSucces-styles.css
│
├── build/                                # Compiled classes
└── Libraries/                            # External jars (if any)


---

## ⚙️ Technologies Used  
- **Java** (Servlets, JSP)  
- **MySQL** (Database)  
- **JDBC** (Database Connectivity)  
- **Tomcat** (Application Server)  
- **HTML, CSS, JSP** (Frontend)  

---

## 🗄️ Database Setup (MySQL)  

Run the following SQL commands before deploying:  

```sql
CREATE DATABASE user_management_db;

USE user_management_db;

CREATE TABLE `user` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fullname VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

## 🛠️ How to Run the Project

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/user-authentication-system.git

