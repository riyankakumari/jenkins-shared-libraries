def call(String project, String imageTag, String dockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: "dockerHubCred",
            usernameVariable: "dockerHubuser",
            passwordVariable: "dockerHubPass"
        )
    ]) {

        sh "echo '${dockerHubPass}' | docker login -u '${dockerHubuser}' --password-stdin"

        sh "docker push ${dockerHubUser}/${project}:${imageTag}"
    }
}
