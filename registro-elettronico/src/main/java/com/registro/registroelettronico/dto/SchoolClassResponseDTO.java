package com.registro.registroelettronico.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.registro.registroelettronico.enums.SchoolClassLabel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SchoolClassResponseDTO {
	private UUID id;
	private SchoolClassLabel name;
	private LocalDate yearStart;
	private LocalDate yearEnd;
}
