node {
   def mvnHome

   stage('Clone Project') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/rockdanielsl/test-junit.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'maven'
   }
   
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   
   stage("SonarQube Analysis") {
          withSonarQubeEnv('Sonar') {
             bat 'mvn clean install sonar:sonar'
          }    
      }
      
      stage("SonarQube Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }    
}