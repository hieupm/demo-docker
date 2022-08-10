pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'openjdk17'
    }
    stages {
        stage('Build and Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                sh 'sudo docker-compose -f docker-compose.yaml build'
                sh 'sudo docker-compose -f docker-compose.yaml up -d'
            }
        }
    }
}
