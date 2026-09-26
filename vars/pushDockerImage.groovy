def call(String project, String imageTag, String dockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: "dockerHubCred",
            usernameVariable: "dockerHubUsername",
            passwordVariable: "dockerHubPassword"
        )
    ]) {

        sh """
            echo '${dockerHubPassword}' | docker login \
                -u '${dockerHubUsername}' \
                --password-stdin

            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
