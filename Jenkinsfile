podTemplate(containers: [
    containerTemplate(
        name: 'jnlp', 
        image: 'jenkins/inbound-agent:latest'
        )
  ]) {

    node(POD_LABEL) {
        
        stage('Code Pull') {
                    
                checkout([$class: 'GitSCM', branches: [[name: '*/feature1']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/apgandhamwar/Java-MicroServices-DevOps-EndToEnd']]])
                }
        stage('Permissions') {
                    sh 'chmod 775 *'
                }
        stage('Cleanup') {
                    sh './gradlew --no-daemon clean'
                }
        stage('Sonarqube') {
            withSonarQubeEnv() {
                    sh './gradlew --no-daemon jacocoTestReport sonarqube'
            }
                    
                }
        try {
                stage('Test'){
                        sh './gradlew --no-daemon check'
            }

        } catch (e) {

            echo 'Catch'

        } finally {
            junit 'build/test-results/test/*.xml'
        }
               
    }
}

