pipeline {
    agent any
    
    environment {
        driver_path = 'src/test/resources/webdrivers/windows/chromedriver.exe'
        username = "standard_user"
        password = "secret_sauce"
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('test') {
            steps {
                git 'https://github.com/RomanShcherbich/SeleniumAdvancedDemoLesson.git'
                bat "mvn clean install"
                bat "mvn allure:report"
            }
            
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        
        stage('report') {
            steps {
                script {
                    allure ([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                        ])
                }
            }
        }
        
    }
}
