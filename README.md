# Bulk Email Sender

This is a simple Spring Boot application to send bulk emails in batches.

## Description
The Bulk Email Sender application is designed to send emails to a large number of recipients efficiently. It leverages Spring Boot, Spring Security, and JavaMailSender to handle email sending in batches with a delay between batches to avoid overwhelming the email server. This application is ideal for scenarios like sending newsletters, updates, or notifications to a large audience.

## Features
- Asynchronous email sending
- Batch processing of emails
- Spring Boot framework for easy setup and development
- Secure email sending using Spring Security
- Attachments support

## Getting Started

### Prerequisites
- Java 8 or later
- Maven 3.8.5 or later
- Spring Boot 2.3.7

### Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/bulk-email-sender.git
    cd bulk-email-sender
    ```

2. Create a `application.properties` file in the `src/main/resources` directory with the following content:
    ```plaintext
    spring.application.name=Bulk Email Sending Application
    spring.mail.host=smtp.gmail.com
    spring.mail.port=587
    spring.mail.username=YOUR_EMAIL
    spring.mail.password=YOUR_PASSWORD
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.enable=true
    ```

3. Build and run the application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### API Endpoints
- `GET /send-emails` - Triggers sending of bulk emails.

### Contributing
We welcome contributions to improve the Bulk Email Sender application! To contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request to the `main` branch.

For major changes, please open an issue first to discuss what you would like to change.

### License
This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.
