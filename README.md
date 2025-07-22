
# **🧠 BrainBox Role-Based Access System**

This project demonstrates a **Role-Based Access Control (RBAC)** implementation using **Spring Boot**, **Spring Security**, and **MySQL**.
It supports multiple user roles with different levels of access to an **Article Management System**.

---

## **📁 Project Structure**

* **Java Backend**: Developed using Spring Boot.
* **MySQL Database**: Stores users, roles, articles, and their relationships.
* **Spring Security**: Configured with `JdbcUserDetailsManager` to authenticate users and authorize them based on roles.

---

## **🛡️ User Roles & Permissions**

| **Role**        | **Permissions**                                                                                |
| --------------- | ---------------------------------------------------------------------------------------------- |
| **Admin**       | 📝 Edit all articles  <br> 🗑️ Delete any article <br> ✅ Approve articles <br> 👥 Assign roles |
| **Editor**      | 📝 Edit assigned articles <br> 🗂️ Review contributor drafts                                   |
| **Contributor** | ✍️ Create articles <br> 🔄 Edit own articles (before approval)                                 |
| **Reviewer**    | ✅ Approve/Reject submitted articles                                                            |
| **Viewer**      | 👀 Read articles only                                                                          |

> A user can have multiple roles
> *(e.g., John is Admin + Editor + Contributor + Reviewer + Viewer)*

---

## **🧑‍💻 Database Schema**

### **Tables**

* **`user`** – Stores user credentials (`id`, `username`, `password`)
* **`role`** – Defines roles (`id`, `name`)
* **`user_roles`** – Maps users to roles (`user_id`, `role_id`)
* **`article`** – Stores articles (`id`, `title`, `content`, `author_id`, `status`)

---

### **Sample Data**

#### **Users**

| **ID** | **Username** | **Role(s)**       |
| ------ | ------------ | ----------------- |
| 1      | john         | Admin (All roles) |
| 2      | alice        | Reviewer          |
| 3      | bob          | Contributor       |
| 4      | seema        | Viewer            |
| 5      | manu         | Editor            |

#### **Roles**

| **ID** | **Role**    |
| ------ | ----------- |
| 1      | ADMIN       |
| 2      | EDITOR      |
| 3      | CONTRIBUTOR |
| 4      | REVIEWER    |
| 5      | VIEWER      |

---


## 📁 **Folder Structure**

This is the typical structure for the **BrainBox** Spring Boot project with Thymeleaf templates and role-based access system:

```bash
brainbox/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── brainbox/
│       │           ├── config/              # Spring Security Configurations
│       │           ├── controller/          # Role-specific Controllers (Admin, Contributor, etc.)
│       │           ├── model/               # Entity classes: User, Role, Article
│       │           ├── repository/          # Spring Data JPA Repositories
│       │           ├── service/             # Business logic & services
│       │           └── BrainboxApplication.java  # Main entry point
│       └── resources/
│           ├── static/                      # CSS, JS, images
│           ├── templates/                   # Thymeleaf HTML files (login, dashboard, etc.)
│           │   ├── login.html
│           │   ├── adminDashboard.html
│           │   ├── contributorDashboard.html
│           │   ├── editorDashboard.html
│           │   ├── viewerDashboard.html
│           │   └── reviewerDashboard.html
│           └── application.properties       # Configuration settings
├── .gitignore
├── pom.xml                                  # Maven dependencies
└── README.md
```

---

## 🚀 **How to Run the Project**


### ✅ **1. Prerequisites**

Ensure the following are installed:

| Tool     | Version                      |
| -------- | ---------------------------- |
| Java JDK | 17+                          |
| Maven    | 3.6+                         |
| MySQL    | 5.7+ or 8+                   |
| IDE      | IntelliJ / Eclipse / VS Code |
| Browser  | Chrome / Edge                |

---

### ⚙️ **2. Configure MySQL**

1. Open your MySQL terminal or GUI (like MySQL Workbench)
2. Create the database:

```sql
CREATE DATABASE brainbox_db;
```

3. (Optional) You can create tables manually or let Spring auto-generate them using `spring.jpa.hibernate.ddl-auto=update`.

---

### 🧾 **3. Setup `application.properties`**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/brainbox_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080
spring.thymeleaf.cache=false
```

> Replace `your_password` with your actual MySQL password.

---

### 🛠️ **4. Build and Run the App**

Open terminal and run:

```bash
cd brainbox
mvn clean install
mvn spring-boot:run
```

Or open the project in your IDE and run the `main()` method in `BrainboxApplication.java`.

---

### 🧪 **5. Access the App**

Open your browser and go to:

```
http://localhost:8080/login
```



