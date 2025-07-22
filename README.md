
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


