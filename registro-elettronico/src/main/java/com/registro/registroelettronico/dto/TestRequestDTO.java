package com.registro.registroelettronico.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.registro.registroelettronico.enums.TestType;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestRequestDTO {
	
	@NotNull(message = "Subject class id is required")
	private UUID subjectClassId;
	
	@NotNull(message = "Type test is required")
	private TestType type;
	
	@NotNull(message = "Due date is required")
	@Future(message = "Due date must be in the future")
	private LocalDate dueDate;
	
	@Builder.Default
	private LocalDateTime createdAt = LocalDateTime.now();

}
