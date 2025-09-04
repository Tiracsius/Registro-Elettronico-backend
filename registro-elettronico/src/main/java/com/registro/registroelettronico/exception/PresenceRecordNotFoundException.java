package com.registro.registroelettronico.exception;

import java.util.UUID;

public class PresenceRecordNotFoundException extends RuntimeException{

    public PresenceRecordNotFoundException(UUID id) {
        super("Presence record with ID " + id + " not found");
    }
}
