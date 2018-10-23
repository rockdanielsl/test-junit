node {
   def mvnHome

   stage('Preparation') { // for display purposes
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
   stage('Build Sonar') {
         bat(/"${mvnHome}\bin\mvn" sonar:sonar -Dsonar.host.url=http:\/\/localhost:9000 -Dsonar.login=abb0d569c5439f5a3b04d86ea16550a9b5a5ef68/)
   }

   stage("SonarQube Quality Gate") { 
        timeout(time: 1, unit: 'HOURS') { 
           def qg = waitForQualityGate() 
           if (qg.status != 'OK') {
             error "Pipeline aborted due to quality gate failure: ${qg.status}"
           }
           else{
               echo 'Sonar Quality Gate esta OK'
           }
        }
    }
}