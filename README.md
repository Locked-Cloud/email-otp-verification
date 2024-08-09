# Email OTP Verification Application

This is a Java-based application built with Spring Boot, designed for email OTP (One-Time Password) verification. It leverages Google's security keys to ensure secure email transmission.

## Features

- **Secure OTP Generation**: Generates a one-time password that is sent to the user's email.
- **Email Integration**: Sends OTPs using Gmail's SMTP server.
- **Easy Configuration**: Simple setup process through the `application.properties` file.

## Getting Started

To set up the application:

1. **Clone the Repository**:
   ```bash
   git clone <your-repo-url>
   cd <repository-name>
Configure Email Settings:

Navigate to src/main/resources/application.properties and update the email and security key fields:

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@example.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
Replace your-email@example.com with your Gmail address.
Replace your-app-password with your generated Google App Password.


Run the Application:

./mvnw spring-boot:run
Prerequisites
Java 11 or higher
Maven (if not using the included wrapper)
Google Account with 2-Step Verification enabled and an App Password generated for the application.
Usage
Once the application is running, it will send an OTP to the specified email address for verification purposes. You can integrate this feature into your own projects to enhance security.

Contributing
Feel free to fork the repository and submit pull requests for any enhancements or bug fixes.

License
This project is licensed under the MIT License.

Replace `<your-repo-url>` with the actual URL of your repository and `<repository-name>` with the name of your repository. This markdown will give you a well-formatted and informative README file on GitHub.
