package com.registro.registroelettronico.exception;

public class SchoolClassesAlreadyExistException extends RuntimeException{
	
	public SchoolClassesAlreadyExistException(int yearStart) {
		super("Classes for " + yearStart + "-" + (yearStart + 1) + " already exist");
	}

}
