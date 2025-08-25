package com.registro.registroelettronico.dto;

import com.registro.registroelettronico.enums.UserRole;
import lombok.Data;

/**
 * Data transfer object for user registration. Includes credentials, role and
 * domain-specific information.
 */
@Data
public class RegisterRequest {
    private String username;
    private String password;
    private UserRole role;
    private String firstName;
    private String lastName;
    private String email;
    private String cardId;
}