package com.registro.registroelettronico.mapper;

import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.TestRequestDTO;
import com.registro.registroelettronico.dto.TestResponseDTO;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.entity.Test;

@Component
public class TestMapper {
	
	public TestResponseDTO toDTO(Test test) {
		return TestResponseDTO.builder()
				.createdAt(test.getCreatedAt())
				.dueDate(test.getDueDate())
				.id(test.getId())
				.subjectClassId(test.getSubjectClass().getId())
				.type(test.getType())
				.build();
	}
	
	public Test toEntity(TestRequestDTO request, SubjectClass subjectClass) {
		return Test.builder()
				.createdAt(request.getCreatedAt())
				.dueDate(request.getDueDate())
				.type(request.getType())
				.subjectClass(subjectClass)
				.build();
	}
}
