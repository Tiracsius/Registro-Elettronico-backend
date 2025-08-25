package com.registro.registroelettronico.dto;

import lombok.Data;

/**
 * Data transfer object for login requests. Contains username and password.
 */
@Data
public class AuthRequest {
    private String username;
    private String password;
}