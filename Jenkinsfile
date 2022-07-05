pipeline {
    agent{
        kubernetes{
            containerTemplate{
                name 'jnlp',
                image 'jenkins/inbound-agent:latest'
            }
        }
    }
}

    stage('Get a Maven project') {
            container('jnlp') {
                stage('Shell Execution') {
                    sh '''
                    echo "Hello! I am executing shell"
                    '''
                }
            }
        }
