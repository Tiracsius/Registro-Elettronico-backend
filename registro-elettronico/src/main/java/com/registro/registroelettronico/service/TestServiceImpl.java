package com.registro.registroelettronico.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.TestRequestDTO;
import com.registro.registroelettronico.dto.TestResponseDTO;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.entity.Test;
import com.registro.registroelettronico.exception.SubjectNotFoundException;
import com.registro.registroelettronico.mapper.TestMapper;
import com.registro.registroelettronico.repository.SubjectClassRepository;
import com.registro.registroelettronico.repository.TestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{
	
	private final TestMapper testMapper;
	private final SubjectClassRepository subjectClassRepository;
	private final TestRepository testRepository;
	
	@Override
	public void createTest(TestRequestDTO request) {
		SubjectClass subjectClass = subjectClassRepository.findById(request.getSubjectClassId())
				.orElseThrow(() -> new SubjectNotFoundException(request.getSubjectClassId()));
		Test test = testMapper.toEntity(request, subjectClass);
		testRepository.save(test);
	}

	@Override
	public TestResponseDTO getTestByDateAndSubjectClassId(LocalDate date, UUID subjectClassId) {
		return testRepository.findFirstByDueDateAndSubjectClass_Id(date, subjectClassId)
				.map(testMapper::toDTO)
				.orElse(null);
	}

	@Override
	public List<TestResponseDTO> getTestByDateAndClassId(LocalDate date, UUID classId) {
		List<TestResponseDTO> tests= testRepository.findAllByDueDateAndSubjectClass_SchoolClass_Id(date, classId)
				.stream()
				.map(testMapper::toDTO)
				.toList();
		return tests;
	}

}
