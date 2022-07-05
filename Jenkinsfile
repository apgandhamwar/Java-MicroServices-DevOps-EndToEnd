podTemplate(containers: [
    containerTemplate(
        name: 'jnlp', 
        image: 'jenkins/inbound-agent:latest'
        )
  ]) {

    node(POD_LABEL) {

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

    }
}

