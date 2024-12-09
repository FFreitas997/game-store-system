package com.ffreitas.gamestoreserver.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInformation implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder
                .withDetail("application", "Game Store Server")
                .withDetail("version", "1.0.0")
                .withDetail("description", "Game Store Server is a REST API that allows you to manage a game store.")
                .withDetail("author", "Francisco Freitas")
                .withDetail("LinkedIn", "https://www.linkedin.com/in/francisco-freitas-a289b91b3/")
                .withDetail("Github", "https://github.com/FFreitas997");
    }
}
