pipeline{
    agent any
     tools {
        maven "default"
    }
    stages
    {
        stage('checkout'){
       steps{
           git branch:'main',url: 'https://github.com/BirenAmanta/test.git'
        }
        }
        stage('Build')
        {
            steps
            {
                bat 'clean install'
            }
        }
        stage('Test')
        {
            steps
            {
                bat 'test'
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
      
}