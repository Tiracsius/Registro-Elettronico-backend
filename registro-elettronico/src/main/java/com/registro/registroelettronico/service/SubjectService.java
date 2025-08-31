package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.dto.SubjectResponseDTO;


public interface SubjectService {

	public List<SubjectResponseDTO> getAllSubjects();
	public SubjectResponseDTO getSubjectById(UUID id);

}