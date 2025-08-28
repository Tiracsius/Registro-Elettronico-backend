package com.registro.registroelettronico.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectClassRequestDTO {

    @NotNull
    private UUID materiaId;

    @NotNull
    private UUID classeId;

}
