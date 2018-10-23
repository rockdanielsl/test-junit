node {
   def mvnHome
   
   stage('Build') {
      mvnHome = tool 'maven'
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
}