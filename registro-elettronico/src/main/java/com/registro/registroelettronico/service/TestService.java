package com.registro.registroelettronico.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.dto.TestRequestDTO;
import com.registro.registroelettronico.dto.TestResponseDTO;

public interface TestService {

	public void createTest(TestRequestDTO request);
	public TestResponseDTO getTestByDateAndSubjectClassId(LocalDate date, UUID subjectClassId);
	public List<TestResponseDTO> getTestByDateAndClassId(LocalDate date, UUID classId);
	
}
