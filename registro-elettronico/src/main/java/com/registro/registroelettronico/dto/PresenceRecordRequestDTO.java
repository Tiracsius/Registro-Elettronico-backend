package com.registro.registroelettronico.dto;

import com.registro.registroelettronico.enums.PresenceStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PresenceRecordRequestDTO {

    @NotNull(message = "Status is required")
    private PresenceStatus status;

    @NotNull(message = "Student id is required")
    private UUID studentId;

    @Builder.Default
    private LocalDate date = LocalDate.now();
}
