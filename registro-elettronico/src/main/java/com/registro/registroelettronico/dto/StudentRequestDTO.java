package com.registro.registroelettronico.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StudentRequestDTO extends UserRequestDTO{

    @NotNull(message="Birthday date is required")
    @Past(message="Birthday must be in the past")
    private LocalDate birthDate;

    @NotNull(message="Parent is required")
    private UUID parentId;

    @NotNull(message="Class is required")
    private UUID classId;

}
