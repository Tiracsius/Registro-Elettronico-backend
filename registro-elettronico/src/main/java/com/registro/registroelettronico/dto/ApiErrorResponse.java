package com.registro.registroelettronico.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class ApiErrorResponse {
	
	private String message;
	private int status;
	private List<FieldError> errors;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class FieldError {
		
		private String field;
		private String message;
	}
}
