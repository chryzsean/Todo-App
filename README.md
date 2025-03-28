# **Simple To-Do Application 📝**

This is a simple To-Do application built using **Java & Spring Boot**, featuring authentication, task management, and a date picker for selecting due dates.

## **Features 🚀**
### **User Authentication 🔐**
Login is required to access the application. Authentication details can be found in application.properties if you want to try a custom username.

### **Task Management ✅**

Add tasks with a **title and due date**

**Update or delete** tasks as needed

Mark tasks as **completed**

### **Date Picker 📅**
When selecting a due date, a **date picker** pops up instead of manually typing the date.

### **Getting Started 💻**

### Prerequisites
- **Docker 🐳 (For running MySQL container)**

- **Java 17+ ☕**

- **Maven 📦**

## Setting Up the Database
1. Ensure Docker is running.

2. Run the following command to start a MySQL container:
```sh 
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=todo_db -p 3306:3306 -d mysql
```

## Running the Application
1. Clone the repository:
```sh
git clone https://github.com/yourusername/todo-app.git
cd todo-app
```

2. Update database credentials in application.properties (if needed).
3. Build and run the project:
```sh
mvn spring-boot:run
```


## Technologies Used 🛠️

- **Spring Boot**

- **Spring Security**

- **Spring Data JPA**

- **MySQL** (AWS RDS)

- **Docker**

- **JSP & JSTL** (for frontend templates)

- **HTML & CSS** (for UI styling)

- **JSP Fragments** (for reusable header and footer)
