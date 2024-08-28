package com.paccy.configuration_server;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnvChecker {

    private final Dotenv dotenv;

    @Autowired
    public EnvChecker(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public void checkEnvVariables() {
        String githubClientId = dotenv.get("GITHUB_CLIENT_ID");
        String githubClientSecret = dotenv.get("GITHUB_CLIENT_SECRET");

        System.out.println("GitHub Client ID: " + githubClientId);
        System.out.println("GitHub Client Secret: " + githubClientSecret);
    }
}
