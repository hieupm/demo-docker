pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Install') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                bat 'sudo docker-compose -f docker-compose.yml build'
                bat 'sudo docker-compose -f docker-compose.yml up -d'
            }
        }
    }
}
