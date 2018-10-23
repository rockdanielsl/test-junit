try {
stage("Building SONAR ...") {
sh './gradlew clean sonarqube'
}
} catch (e) {emailext attachLog: true, body: 'See attached log', subject: 'BUSINESS Build Failure', to: 'abc@gmail.com'
step([$class: 'WsCleanup'])
retu