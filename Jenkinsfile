pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Test') {
            withEnv(["PATH=$PATH:~/.local/bin"]){
                    sh "bash test.sh"
                }
        }
        stage('Build') {
            steps {
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
                sh 'docker-compose -f docker-compose.yml build'
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }
    }
}
