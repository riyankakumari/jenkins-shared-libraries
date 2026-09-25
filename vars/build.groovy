def call(String ProjectTag ,String ImageTag,String DockerHubUser ){
  sh "docker build -t ${DockerHubUser}/${ProjectTag}:${ImageTag} ."
}
