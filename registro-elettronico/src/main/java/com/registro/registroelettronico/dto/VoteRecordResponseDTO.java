package com.registro.registroelettronico.dto;

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
public class VoteRecordResponseDTO {
    private UUID id;
    private Double vote;
    private String subject;
    private LocalDate createdAt;
}
