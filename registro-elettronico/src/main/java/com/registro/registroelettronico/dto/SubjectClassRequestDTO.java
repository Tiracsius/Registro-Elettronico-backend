package com.registro.registroelettronico.dto;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectClassRequestDTO {

    @NotNull(message="Subject is required")
    private UUID subjectId;

    @NotNull(message="Class is required")
    @Size(min=1, message="At least one class is required")
    private List<UUID> classeIds;

}
