package com.registro.registroelettronico.dto;

import com.registro.registroelettronico.enums.PresenceStatus;
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

    private PresenceStatus status;
    private UUID studentId;

    @Builder.Default
    private LocalDate date = LocalDate.now();
}
