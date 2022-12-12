pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
//                 sh 'docker-compose up -d --build'
                sh 'docker run -p 5432:5432 --name my-postgres -e POSTGRES_PASSWORD=1234 -e POSTGRES_DATABASE=demo postgres'
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
