package com.registro.registroelettronico.mapper;

import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.SubjectResponseDTO;
import com.registro.registroelettronico.entity.Subject;

@Component
public class SubjectMapper {
	
	public SubjectResponseDTO toDTO(Subject subject) {
		return SubjectResponseDTO.builder()
				.id(subject.getId())
				.name(subject.getName())
				.build();
	}

}
