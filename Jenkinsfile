podTemplate(containers: [
    containerTemplate(
        name: 'jnlp', 
        image: 'jenkins/inbound-agent:latest'
        )
  ]) {

    node(POD_LABEL) {
        stage('Permissions') {
                    sh 'chmod 775 *'
                }	
        stage('Cleanup') {
                    sh './gradlew --no-daemon clean'
                }
    }
}

