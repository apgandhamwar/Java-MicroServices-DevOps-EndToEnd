pipeline {
    agent any

    stages {

       

        stage('Permissions') {
            steps {
                sh 'chmod 775 *'
            }
        }

stage('Cleanup') {
            steps {
                sh './gradlew --no-daemon clean'
            }
        }

stage('Sonar') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh './gradlew --no-daemon sonarqube'
            }
            }
        }
        
stage('Test') {
            steps {
                sh './gradlew --no-daemon check'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }
        stage('Build') {
            steps {
                sh './gradlew --no-daemon build'
            }
        }
        
     stage('Artifact Versioning') {
            steps {
                sh 'git remote remove origin'
                sh 'git remote set-url origin git@github.com:apgandhamwar/Java-MicroServices-DevOps-EndToEnd.git'
                sh './gradlew --no-daemon release -Prelease.useAutomaticVersion=true -Prelease.releaseVersion=1.0.0 -Prelease.newVersion=1.1.0-SNAPSHOT'
            }
        }
   
    }
}
