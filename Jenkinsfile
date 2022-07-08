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
                sh 'git remote add origin https://apgandhamwar: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@github.com/apgandhamwar/Java-MicroServices-DevOps-EndToEnd.git'
                sh './gradlew --no-daemon release -Prelease.useAutomaticVersion=true -Prelease.releaseVersion=1.0.0 -Prelease.newVersion=1.1.0-SNAPSHOT'
            }
        }
   
    }
}
