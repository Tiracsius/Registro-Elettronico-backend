package com.registro.registroelettronico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Data transfer object containing the JWT token returned after
 * authentication or registration.
 */
@Data
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private UserResponseDTO user;
}