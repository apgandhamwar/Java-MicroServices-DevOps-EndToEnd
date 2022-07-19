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

stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "./gradlew sonarqube"
                }
            }
        }
        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
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
                
     stage('Artifact Versioning') {
            steps {
                sh 'git remote remove origin'
                sh 'git remote add origin git@github.com:apgandhamwar/Java-MicroServices-DevOps-EndToEnd.git'
                sh './gradlew --no-daemon release -Prelease.useAutomaticVersion=true -Prelease.newVersion=6.0.0-SNAPSHOT'
            }
        }
        
     stage('Publish') {
            steps {
                sh './gradlew --no-daemon publish'
            }
        }
   
    }
}
