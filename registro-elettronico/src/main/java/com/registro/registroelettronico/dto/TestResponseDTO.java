package com.registro.registroelettronico.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.registro.registroelettronico.enums.TestType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestResponseDTO {
	
	private UUID id;
	private UUID subjectClassId;
	private TestType type;
	private LocalDate dueDate;
	private LocalDateTime createdAt;

}
