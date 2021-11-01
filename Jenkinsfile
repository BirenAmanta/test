pipeline{
    agent{ label 'Build-In Node'}
    tools{
        maven 'default'
    }
    stages
    {
        stage('checkout'){
       steps{
           git 'https://github.com/BirenAmanta/test.git'
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