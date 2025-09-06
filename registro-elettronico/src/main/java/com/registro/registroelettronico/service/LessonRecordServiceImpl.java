package com.registro.registroelettronico.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.LessonRecordRequestDTO;
import com.registro.registroelettronico.dto.LessonRecordResponseDTO;
import com.registro.registroelettronico.entity.LessonRecord;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.mapper.LessonRecordMapper;
import com.registro.registroelettronico.repository.LessonRecordRepository;
import com.registro.registroelettronico.repository.SubjectClassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LessonRecordServiceImpl implements LessonRecordService{
	
	private final LessonRecordRepository lessonRecordRepository;
	private final SubjectClassRepository subjectClassRepository;
	private final LessonRecordMapper lessonRecordMapper;
	
	@Override
	public void createLessonRecord(LessonRecordRequestDTO request) {
		SubjectClass subjectClass = subjectClassRepository.findById(request.getSubjectClassId())
				.orElseThrow(() -> new SubjectNotFoundException(request.getSubjectClassId()));
		LessonRecord lessonRecord = lessonRecordMapper.toEntity(request, subjectClass);
		lessonRecordRepository.save(lessonRecord);
		
		
	}

	@Override
	public LessonRecordResponseDTO getLessonRecordByDateAndSubjectClassId(LocalDate date, UUID subjectClassId) {
		LocalDateTime start = date.atStartOfDay();
		LocalDateTime end = date.atTime(LocalTime.MAX);
		
		return lessonRecordRepository.findFirstByCreatedAtBetweenAndSubjectClass_Id(start, end, subjectClassId)
				.map(lessonRecordMapper::toDTO)
				.orElse(null);
	}

	@Override
	public List<LessonRecordResponseDTO> getLessonRecordByDateAndClassId(LocalDate date, UUID classId) {
		LocalDateTime start = date.atStartOfDay();
		LocalDateTime end = date.atTime(LocalTime.MAX);
		
		return lessonRecordRepository.findAllByCreatedAtBetweenAndSubjectClassSchoolClass_Id(start, end, classId)
				.stream()
				.map(lessonRecordMapper::toDTO)
				.toList();
	}
}
