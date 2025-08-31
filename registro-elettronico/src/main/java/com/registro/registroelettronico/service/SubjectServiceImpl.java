package com.registro.registroelettronico.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.SubjectResponseDTO;
import com.registro.registroelettronico.entity.Subject;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.mapper.SubjectMapper;
import com.registro.registroelettronico.repository.SubjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService{

	 private final SubjectRepository subjectRepository;
	 private final SubjectMapper subjectMapper;

	@Override
	public List<SubjectResponseDTO> getAllSubjects() {
		List<SubjectResponseDTO> subjects = subjectRepository.findAll().stream()
				.map(subjectMapper::toDTO)
				.toList();
		return subjects;
	}

	@Override
	public SubjectResponseDTO getSubjectById(UUID id) {
		Subject subject = subjectRepository.findById(id).orElseThrow(
				() -> new SubjectNotFoundException(id));
		return subjectMapper.toDTO(subject);
	}

}
