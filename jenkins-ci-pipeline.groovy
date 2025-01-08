pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Access the Git URL from the environment variable
                    def gitUrl = env.GIT_URL
                    
                    // Checkout the repository
                    checkout([$class: 'GitSCM',
                        branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: gitUrl]]
                    ])
                }
            }
        }
        stage('Lint') {
            steps {
                sh 'echo "Running lint..."'
            }
        }
        stage('Build') {
            steps {
                sh 'echo "Bulding..."'
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Testing..."'
            }
        }
    }
}
