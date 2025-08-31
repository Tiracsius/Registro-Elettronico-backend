package com.registro.registroelettronico.exception;

import java.util.UUID;

public class SecretaryNotFoundException extends RuntimeException{
	
	public SecretaryNotFoundException(UUID id) {
		super("Secretary with ID " + id + " not found");
	}

}
