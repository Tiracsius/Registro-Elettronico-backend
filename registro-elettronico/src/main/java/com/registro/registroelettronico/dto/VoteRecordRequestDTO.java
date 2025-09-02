package com.registro.registroelettronico.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoteRecordRequestDTO {

    @NotNull(message = "Vote is required")
    @DecimalMin(value = "0.0", message = "Vote must be greater than 0")
    @DecimalMax(value = "10.0", message = "Vote must not be greater than 10")
    private Double vote;

    @Builder.Default
    private LocalDateTime date = LocalDateTime.now();

    @NotNull(message = "StudentId is required")
    private UUID studentId;

    @NotNull(message = "SubjectClassId is required")
    private UUID subjectClassId;
}
