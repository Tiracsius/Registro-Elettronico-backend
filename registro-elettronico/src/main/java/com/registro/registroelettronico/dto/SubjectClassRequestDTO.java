package com.registro.registroelettronico.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectClassRequestDTO {

    @NotNull
    private UUID materiaId;

    @NotNull
    private List<UUID> classeIds;

}
