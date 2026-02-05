🚀 API Gateway Microservices Project

A complete end-to-end microservices application built using Java 17, Spring Boot, API Gateway, Docker, Jenkins, SonarQube, and Kubernetes, with APIs tested via Postman.

This project is designed to demonstrate real-world microservices architecture and CI/CD best practices.

📌 Overview

This project demonstrates how to build, containerize, and deploy Spring Boot microservices using an API Gateway and a CI/CD pipeline.

It includes:

Multiple backend microservices

Centralized API Gateway

Dockerized services

Jenkins CI with SonarQube quality checks

Kubernetes deployment

End-to-end API testing using Postman

🏗️ Architecture
Postman
|
API Gateway (8080)
|
--------------------------------
| User Service (8081)          |
| Order Service (8082)         |
--------------------------------
|
Docker / Kubernetes

🧰 Tech Stack

Language: Java 17

Framework: Spring Boot 3.x

Build Tool: Gradle (Wrapper)

API Gateway: Spring Cloud Gateway

Containerization: Docker, Docker Compose

CI/CD: Jenkins

Code Quality: SonarQube

Orchestration: Kubernetes (Minikube)

API Testing: Postman

📁 Project Structure
api-gateway-microservices/
│
├── api-gateway/
│   ├── src/main/java/com/example/apigateway
│   ├── src/main/resources/application.yml
│   ├── build.gradle
│   ├── gradlew
│   └── Dockerfile
│
├── user-service/
│   ├── src/main/java/com/example/userservice
│   ├── src/main/resources/application.yml
│   ├── build.gradle
│   ├── gradlew
│   └── Dockerfile
│
├── order-service/
│   ├── src/main/java/com/example/orderservice
│   ├── src/main/resources/application.yml
│   ├── build.gradle
│   ├── gradlew
│   └── Dockerfile
│
├── k8s/
│   ├── user-deployment.yaml
│   ├── order-deployment.yaml
│   ├── gateway-deployment.yaml
│   └── service.yaml
│
├── docker-compose.yml
├── Jenkinsfile
└── README.md

🛠️ Installation & Setup
🔹 Prerequisites

Ensure the following are installed:

Git

Java 17

Docker & Docker Compose

Postman

(Optional) Kubernetes – Minikube

(Optional) Jenkins & SonarQube

🔹 Install Java 17 (Ubuntu)
sudo apt update
sudo apt install openjdk-17-jdk -y


Verify:

java --version

🔹 Install Docker (Ubuntu)
sudo apt update
sudo apt install docker.io -y
sudo systemctl start docker
sudo systemctl enable docker


Add user to Docker group:

sudo usermod -aG docker $USER
newgrp docker


Verify:

docker --version

🔹 Install Docker Compose
sudo apt install docker-compose -y


Verify:

docker-compose --version

🔹 Clone the Repository
git clone https://github.com/SeshadriPutturu/api-gateway-microservices.git
cd api-gateway-microservices

🔹 Gradle Usage (Important)

This project uses the Gradle Wrapper.
No system Gradle installation is required.

✅ Always use:

./gradlew clean build


❌ Do not use:

gradle build

🔹 Microservices Details
👤 User Service

Port: 8081

Endpoint:

GET /users/{id}

📦 Order Service

Port: 8082

Endpoint:

GET /orders/{id}

🌐 API Gateway

Port: 8080

Routes:

/users/**  → user-service
/orders/** → order-service

▶️ Running Locally (Without Docker)
cd user-service
./gradlew bootRun

cd order-service
./gradlew bootRun

cd api-gateway
./gradlew bootRun

Test using Postman
GET http://localhost:8080/users/1
GET http://localhost:8080/orders/101

🐳 Docker & Docker Compose
🔹 Build Docker Images
docker build -t user-service ./user-service
docker build -t order-service ./order-service
docker build -t api-gateway ./api-gateway

🔹 Run All Services
docker-compose up -d


Verify:

docker ps

🔹 Test APIs
GET http://<VM-IP>:8080/users/1
GET http://<VM-IP>:8080/orders/101

⚙️ CI Pipeline (Jenkins + SonarQube)
Jenkins Pipeline Stages

Checkout code from GitHub

Build all services using Gradle Wrapper

Run unit tests

Perform SonarQube code analysis

Fail build if quality gate fails

☸️ Kubernetes Deployment

Kubernetes cluster created using Minikube

Each service deployed as a Deployment

API Gateway exposed using NodePort

Deploy to Kubernetes
kubectl apply -f k8s/

Access APIs
minikube ip

GET http://<MINIKUBE-IP>:30080/users/1
GET http://<MINIKUBE-IP>:30080/orders/101

🧪 API Testing

All APIs were tested using Postman, validating:

API Gateway routing

Inter-service communication

Docker and Kubernetes deployments