package com.registro.registroelettronico.exception;

import java.util.UUID;

public class TeacherNotFoundException extends RuntimeException{
	
	public TeacherNotFoundException(UUID id) {
		super("Teacher with ID " + id + " not found");
	}

}
