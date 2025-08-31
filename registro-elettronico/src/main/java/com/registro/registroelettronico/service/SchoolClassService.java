package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.dto.SchoolClassResponseDTO;

/**
 * Service providing CRUD operations for school classes.
 */
public interface SchoolClassService {

	public List<SchoolClassResponseDTO> getAllSchoolClasses();
	public SchoolClassResponseDTO getSchoolClassById(UUID id);
	public void createSchoolClasses();
	
}