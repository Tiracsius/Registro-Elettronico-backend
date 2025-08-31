package com.registro.registroelettronico.exception;

import java.util.UUID;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(UUID id) {
        super("Student with ID " + id + " not found");
    }

}
