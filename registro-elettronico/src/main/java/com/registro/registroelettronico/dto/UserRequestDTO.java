package com.registro.registroelettronico.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.registro.registroelettronico.enums.UserRole;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "role",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = StudentRequestDTO.class, name = "STUDENT"),
        @JsonSubTypes.Type(value = ParentRequestDTO.class, name = "PARENT"),
        @JsonSubTypes.Type(value = TeacherRequestDTO.class, name = "TEACHER"),
        @JsonSubTypes.Type(value = SecretaryRequestDTO.class, name = "SECRETARY")
})
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class UserRequestDTO {
    @NotNull(message="Role is required")
    private UserRole role;

    @NotBlank(message="Firstname is required")
    private String firstName;

    @NotBlank(message="Lastname is required")
    private String lastName;

    @Email(message="Email invalid")
    @NotBlank(message="Email is required")
    private String email;

}