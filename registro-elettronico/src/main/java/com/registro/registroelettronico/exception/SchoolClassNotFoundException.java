package com.registro.registroelettronico.exception;

import java.util.UUID;

public class SchoolClassNotFoundException extends RuntimeException {

	public SchoolClassNotFoundException(UUID id) {
		super("Class with ID " + id + " not found");
	}

}
