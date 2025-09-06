package com.registro.registroelettronico.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonRecordResponseDTO {
	
	private UUID id;
	private UUID subjectClassId;
	private String message;
	private LocalDateTime date;

}
 