package com.registro.registroelettronico.dto;

import java.time.LocalDate;

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

    /**
     * Basic personal information for the domain entity associated with the
     * credential. These fields are optional depending on the role and
     * can be left null for roles that do not require them.
     */
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthDate;

    /**
     * Identifier of the parent to be associated with a newly registered
     * student. Only required when the role is {@link UserRole#STUDENT}.
     */
    private java.util.UUID parentId;

    /**
     * Identifier of the class the student is enrolled in. Only used for
     * student registrations; ignored for other roles.
     */
    private java.util.UUID classId;
}