package com.registro.registroelettronico.mapper;

import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.SchoolClassResponseDTO;
import com.registro.registroelettronico.entity.SchoolClass;

@Component
public class SchoolClassMapper {

	public SchoolClassResponseDTO toDTO(SchoolClass schoolClass) {
		return SchoolClassResponseDTO.builder()
				.id(schoolClass.getId())
				.name(schoolClass.getName())
				.yearStart(schoolClass.getYearStart())
				.yearEnd(schoolClass.getYearEnd())
				.build();
	}
}
