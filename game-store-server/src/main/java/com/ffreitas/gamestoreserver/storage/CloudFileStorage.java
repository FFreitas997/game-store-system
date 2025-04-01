package com.ffreitas.gamestoreserver.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("prod")
public class CloudFileStorage implements FileStorage {

    @Override
    public void store(byte[] file, String fileName) {

    }

    @Override
    public byte[] load(String fileName) {
        return new byte[0];
    }

    @Override
    public void delete(String fileName) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void init() {

    }
}
