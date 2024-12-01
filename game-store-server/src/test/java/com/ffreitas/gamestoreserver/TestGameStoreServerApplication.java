package com.ffreitas.gamestoreserver;

import org.springframework.boot.SpringApplication;

public class TestGameStoreServerApplication {

    public static void main(String[] args) {
        SpringApplication.from(GameStoreServerApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
