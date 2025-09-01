package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.SubjectClassResponseDTO;
import com.registro.registroelettronico.mapper.SubjectClassMapper;
import com.registro.registroelettronico.repository.SubjectClassRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectClassServiceImpl implements SubjectClassService{
	
	private final SubjectClassRepository subjectClassRepository;
	private final SubjectClassMapper subjectClassMapper;
	
	@Override
	public List<SubjectClassResponseDTO> getAllSubjectClassByTeacherId(UUID teacherId) {
		List<SubjectClassResponseDTO> subjectClasses = subjectClassRepository.findAllByTeacherId(teacherId)
				.stream()
				.map(subjectClassMapper::toDTO)
				.toList();
		return subjectClasses;
	}

}
