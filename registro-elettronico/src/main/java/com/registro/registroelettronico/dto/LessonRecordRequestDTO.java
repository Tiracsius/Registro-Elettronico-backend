package com.registro.registroelettronico.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonRecordRequestDTO {
	
	@NotBlank(message = "Message is required")
	private String message;
	
	@NotNull(message = "Subject class id is required")
	private UUID subjectClassId;
	
	@Builder.Default
	private LocalDateTime date = LocalDateTime.now();

}
