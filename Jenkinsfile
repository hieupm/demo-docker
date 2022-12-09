pipeline {
    agent any
    tools {
        maven 'maven'
    }
    environment {
            PATH = "$PATH:/usr/local/bin"
        }
    stages {
        stage('Build') {
            steps {
                sh 'pwd'
                sh 'docker-compose up -d –build'
                sh 'mvn clean package'
            }
        }
        stage('Install') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Deploy') {
            steps {
                sh 'sudo docker-compose -f docker-compose.yml build'
                sh 'sudo docker-compose -f docker-compose.yml up -d'
            }
        }
    }
}
