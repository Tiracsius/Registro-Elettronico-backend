package com.registro.registroelettronico.dto;

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
public class JustificationResponseDTO {

    private UUID id;
    private String message;
    private LocalDateTime createdAt;

}
