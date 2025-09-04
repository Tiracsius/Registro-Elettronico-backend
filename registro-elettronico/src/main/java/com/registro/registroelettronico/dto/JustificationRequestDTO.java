package com.registro.registroelettronico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JustificationRequestDTO {

    @NotNull(message = "Presence record id is required")
    private UUID presenceRecordId;

    @NotBlank(message = "Message is required")
    private String message;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
