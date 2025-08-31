package com.registro.registroelettronico.exception;

import java.util.UUID;

public class SubjectNotFoundException extends RuntimeException{

	public SubjectNotFoundException(UUID id) {
		 super("Subject with ID " + id + " not found");
	}
}
