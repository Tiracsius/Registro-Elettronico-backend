package com.registro.registroelettronico.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.dto.LessonRecordRequestDTO;
import com.registro.registroelettronico.dto.LessonRecordResponseDTO;

public interface LessonRecordService {
	
	public void createLessonRecord(LessonRecordRequestDTO request);
	public LessonRecordResponseDTO getLessonRecordByDateAndSubjectClassId(LocalDate date, UUID subjectClassId);
	public List<LessonRecordResponseDTO> getLessonRecordByDateAndClassId(LocalDate date, UUID classId);
	
}
