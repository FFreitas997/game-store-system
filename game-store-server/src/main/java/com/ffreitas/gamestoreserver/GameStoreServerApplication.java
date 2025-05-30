package com.ffreitas.gamestoreserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
public class GameStoreServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameStoreServerApplication.class, args);
    }
}
