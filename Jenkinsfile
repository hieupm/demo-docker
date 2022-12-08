pipeline {
    agent any

    stages {
        stage('Build and Test') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                bat 'sudo docker-compose -f docker-compose.yaml build'
                bat 'sudo docker-compose -f docker-compose.yaml up -d'
            }
        }
    }
}
