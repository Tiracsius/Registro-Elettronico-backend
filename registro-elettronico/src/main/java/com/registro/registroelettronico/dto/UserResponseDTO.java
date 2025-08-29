package com.registro.registroelettronico.dto;

import java.util.UUID;

import com.registro.registroelettronico.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserResponseDTO {
	
	private UUID id;
	private String firstName;
	private String lastName;
	private UserRole role;
	private String email;
}
