A full-stack web application built using Java, Spring, and Thymeleaf that allows users to create, edit, and manage blog posts. The platform includes user authentication and role-based access control to ensure secure posting and management of content. This project demonstrates key concepts in Spring Boot, security, and front-end development with responsive design.

Features
User Authentication & Authorization: Users can sign up, log in, and access their profile. Role-based access control is implemented using Spring Security.
Blog Post Management: Authenticated users can create, edit, and delete blog posts.
Rich Text Editing: Integrated CKEditor allows users to format blog content and embed images.
Responsive Design: Front-end built with Thymeleaf and Bootstrap, providing a seamless experience across devices.
Object-Relational Mapping (ORM): JPA is used for efficient database management, allowing seamless data manipulation for blog posts and user information.

Technologies Used

Backend:
Java
Spring Boot
Spring Security
Spring Data JPA (Hibernate)
H2 Database (for testing)

Frontend:
Thymeleaf (for server-side rendering)
Bootstrap (for responsive design)
CKEditor (for rich text editing)

Build Tool: Maven

Prerequisites:
JDK 11 or higher
Maven
Any Java IDE (e.g., IntelliJ, Eclipse)
Git

Installation:
Clone the repository:
git clone https://github.com/umarkazi24/TechFluent.git/

Navigate to the project directory:
cd "Your intended project path"

Build project:
mvn clean install

Run project: 
mvn spring-boot:run

Access the application by navigating to http://localhost:8080 in your web browser.

Default Credentials (You may change these credentials to your preference within the SeedData.java file)
Admin User:
Username: admin@admin.com
Password: pass987

Regular User:
Username: user@user.com
Password: pass987

Database Configuration
The project uses H2 Database for development and testing. To view the database console, navigate to http://localhost:8080/h2-console and use the following credentials:

(Navigate to application.properties to change to your own preferred DB Username and Password)
JDBC URL: jdbc:h2:mem:testdb
Username: admin (Change to preference)
Password: password (Change to preference)

Future Improvements
Integration with a production-grade database (e.g., MySQL or PostgreSQL).
Pagination and search functionality for blog posts.
Enhanced comment system with moderation features.
Deployment on cloud platforms (AWS, Azure, Heroku, etc.).

Contributing
Feel free to fork this repository and create a pull request if you want to contribute. All contributions are welcome!

Contact
For questions or suggestions, feel free to reach out:
Email: umarkazi54@gmail.com
LinkedIn: linkedin.com/in/umarkazi
