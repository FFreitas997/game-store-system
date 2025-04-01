package com.ffreitas.gamestoreserver.storage;

public interface FileStorage {

    void store(byte[] file, String fileName);

    byte[] load(String fileName);

    void delete(String fileName);

    void deleteAll();

    void init();
}
