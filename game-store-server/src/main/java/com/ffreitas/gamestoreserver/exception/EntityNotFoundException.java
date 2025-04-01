package com.ffreitas.gamestoreserver.exception;

public class EntityNotFoundException extends Exception {

    private final String entity;

    public EntityNotFoundException(String entity, String message) {
        super(message);
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }
}
