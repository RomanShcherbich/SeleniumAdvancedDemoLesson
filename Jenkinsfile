pipeline {
    agent any
	
    triggers {
        cron('0 8 * * *')
    }
	
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('test') {
            environment {
            driver_path = "src/test/resources/webdrivers/windows/chromedriver.exe"
            headless = "1"
            sauce_username = "standard_user"
            sauce_password = "secret_sauce"
            loggerLevel = "info"
            }
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/RomanShcherbich/SeleniumAdvancedDemoLesson.git'
                bat "mvn clean test -Dmaven.test.failure.ignore=true"
            }
            post {
                always  {
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
