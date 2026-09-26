def call (String project,String imageTag,String dockerHubUser ){
  withCredentials([usernamePassword(credentialsId:"dockerHubCred", usernameVariable:"dockerHubuser",passwordVariable:"dockerHubPass")])
  sh "docker login -u ${env.dockerHubuser} -p ${env.dockerHubPass}"
  sh "docker image tag notes-app:latest ${env.dockerHubuser}/notes-app:latest"
  sh "docker push ${env.dockerHubuser}/notes-app:latest"
}
