package com.registro.registroelettronico.exception;

import java.util.UUID;

public class ParentNotFoundException extends RuntimeException{

    public ParentNotFoundException(UUID id) {
        super("Parent with ID " + id + " not found");
    }
}
