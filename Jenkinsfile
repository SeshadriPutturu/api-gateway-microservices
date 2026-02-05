pipeline {
    agent any

    environment {
        DOCKER_USER = "seshadri"
        DOCKER_CREDS = credentials('dockerhub-creds')
    }

    stages {

        stage('Build') {
            steps {
                sh '''
                cd order-service && ./gradlew clean build
                cd ../user-service && ./gradlew clean build
                cd ../api-gateway && ./gradlew clean build
                '''
            }
        }

        stage('Docker Build & Push') {
            steps {
                sh '''
                echo $DOCKER_CREDS_PSW | docker login -u $DOCKER_CREDS_USR --password-stdin

                docker build -t $DOCKER_USER/user-service:latest user-service
                docker build -t $DOCKER_USER/order-service:latest order-service
                docker build -t $DOCKER_USER/api-gateway:latest api-gateway

                docker push $DOCKER_USER/user-service:latest
                docker push $DOCKER_USER/order-service:latest
                docker push $DOCKER_USER/api-gateway:latest
                '''
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                kubectl apply -f k8s/
                '''
            }
        }
    }
}
