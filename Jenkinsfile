pipeline {
    agent any

    stages {

        stage('Git') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/feature1']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/apgandhamwar/Java-MicroServices-DevOps-EndToEnd']]])
            }
        }

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
                withSonarQubeEnv() {
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
   
    }
}
