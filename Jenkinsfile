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


        stage('Build') {
            steps {
                sh './gradlew --no-daemon build'
            }
        }
   
    }
}
