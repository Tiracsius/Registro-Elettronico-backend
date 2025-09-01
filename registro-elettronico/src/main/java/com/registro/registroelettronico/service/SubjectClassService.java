package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.dto.SubjectClassResponseDTO;

public interface SubjectClassService {
	
	public List<SubjectClassResponseDTO> getAllSubjectClassByTeacherId(UUID teacherId);
}
