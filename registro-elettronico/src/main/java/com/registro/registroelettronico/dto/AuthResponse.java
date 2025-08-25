package com.registro.registroelettronico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data transfer object containing the JWT token returned after
 * authentication or registration.
 */
@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
}