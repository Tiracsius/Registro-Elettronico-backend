package com.registro.registroelettronico.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class StudentRequestDTO extends UserRequestDTO{

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private UUID parentId;

    @NotNull
    private UUID classId;

}
