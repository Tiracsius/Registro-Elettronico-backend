package com.registro.registroelettronico.exception;

import java.util.UUID;

public class JustificationNotFoundException extends RuntimeException{

    public JustificationNotFoundException (UUID justificationId) {
        super("Justification with ID " + justificationId + " not found");
    }
}
