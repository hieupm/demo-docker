pipeline {
    agent any
    tools {
        maven 'maven'
    }
    environment {
            PATH = "$PATH:/usr/local/bin"
        }
    stages {
        stage('Install packages') {
            steps {
                sh("docker run --user='hieupm' --rm -v `pwd`:/app -w /app node yarn install")
              }
        }
        stage('Build') {
            steps {
                sh 'sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose'
                sh 'sudo docker-compose up -d –build'
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
