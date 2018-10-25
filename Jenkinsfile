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

    stage('Build Docker Image') {
      /* This builds the actual image; synonymous to
       * docker build on the command line */
      withEnv(['PATH+EXTRA=/usr/sbin:/usr/bin:/sbin:/bin']) {
      app = docker.build("test-from-jenkins")
    }
      
    }    
}