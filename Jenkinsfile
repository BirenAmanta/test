pipeline{
    agent any
      environment {
    PATH = "C:\\Program Files\\Git\\usr\\bin;C:\\Program Files\\Git\\bin;${env.PATH}"
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
                sh 'mvm clean compile'
            }
        }
        stage('Test')
        {
            steps
            {
                sh 'mvn test'
                junit '**/target/surefire-reports/TEST-*.xml'
            }
        }
    }
      }
}