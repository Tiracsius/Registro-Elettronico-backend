package com.registro.registroelettronico.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SubjectResponseDTO {
	
	private UUID id;
	private String name;
}
