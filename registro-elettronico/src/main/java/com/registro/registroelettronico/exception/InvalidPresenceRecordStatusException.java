package com.registro.registroelettronico.exception;

public class InvalidPresenceRecordStatusException extends RuntimeException {

    public InvalidPresenceRecordStatusException() {
        super("Invalid PresenceRecord Status for the operation");
    }
}
