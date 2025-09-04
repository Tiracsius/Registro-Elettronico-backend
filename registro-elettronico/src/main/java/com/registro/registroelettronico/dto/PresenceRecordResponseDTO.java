package com.registro.registroelettronico.dto;

import com.registro.registroelettronico.enums.PresenceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class PresenceRecordResponseDTO {
    private UUID id;
    private PresenceStatus status;
    private LocalDate date;
    private StudentSummaryDTO student;
}
