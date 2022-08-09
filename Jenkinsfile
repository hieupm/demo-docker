pipeline {
    agent any
     tools {
        maven 'M3'
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
