# 📷 QR Code Generator - Spring Boot Web Application

This is a **QR Code Generator** web application built using **Spring Boot**, **Java 17**, **JSP**, and **ZXing** (Google’s Barcode API). The app provides a simple web interface and REST API to generate QR codes from input text, display them in PNG or Base64 format, and download them directly.

> ✅ MySQL integration is configured using Docker, allowing easy future extension to store QR code history or logs.

---

## 🚀 Features

- ✅ Generate QR codes from text input
- 🖼️ View QR code as PNG via REST endpoint
- 🔐 Return QR code as Base64 string
- 💾 Download QR code as image
- 🌐 Web UI using JSP
- 🐳 Dockerized MySQL configuration (for future use)
- 🔧 Clean MVC structure

---

## 🛠️ Tech Stack

| Layer         | Technology                         |
|--------------|-------------------------------------|
| Language      | Java 17                             |
| Framework     | Spring Boot 3.5.3                   |
| UI            | JSP, JSTL                           |
| REST API      | Spring Web                          |
| QR Generator  | ZXing (`com.google.zxing`)         |
| DB Config     | MySQL 8 (Docker container)          |
| ORM           | Spring Data JPA (configured)        |
| Build Tool    | Maven                               |
| Container     | Docker                              |

## Dependencies (from pom.xml)
spring-boot-starter-web
spring-boot-starter-security
spring-boot-starter-validation
spring-boot-starter-data-jpa
mysql-connector-j
tomcat-embed-jasper (JSP support)
jakarta.servlet.jsp.jstl
com.google.zxing:core and javase
spring-boot-devtools

## 📂 Project Structure

qrGenerator/
├── controller/
│ ├── PageController.java # Handles JSP home page
│ └── QRCodeController.java # REST API for QR generation
├── util/
│ └── QRCodeGenerator.java # QR generation logic using ZXing
├── resources/
│ ├── application.properties # App + DB configuration
│ └── /WEB-INF/jsp/index.jsp # Simple web interface
└── MyfirstwebappApplication.java # Spring Boot main class

## Run MySQL in Docker
#Docker should be active while running the below command:

docker run --detach \
  --env MYSQL_ROOT_PASSWORD=dummypassword \
  --env MYSQL_USER=social-media-user \
  --env MYSQL_PASSWORD=dummypassword \
  --env MYSQL_DATABASE=social-media-database \
  --name mysql \
  --publish 3306:3306 \
  mysql:8

## visit: http://localhost:8080/

| Method | Endpoint                           | Description                   |
| ------ | ---------------------------------- | ----------------------------- |
| `GET`  | `/api/qr/generate?text=...`        | Returns QR code image (PNG)   |
| `GET`  | `/api/qr/generate-base64?text=...` | Returns Base64 encoded string |
| `GET`  | `/api/qr/download?text=...`        | Download QR code as PNG file  |


## Quick Summary
| Task               | URL / Command                            |
| ------------------ | ---------------------------------------- |
| Web Form           | `http://localhost:8080/`                 |
| Generate PNG QR    | `GET /api/qr/generate?text=Hello`        |
| Generate Base64 QR | `GET /api/qr/generate-base64?text=Hello` |
| Download QR Code   | `GET /api/qr/download?text=Hello`        |
| Run MySQL (Docker) | See Docker command above                 |
| Run App            | `mvn spring-boot:run`                    |
