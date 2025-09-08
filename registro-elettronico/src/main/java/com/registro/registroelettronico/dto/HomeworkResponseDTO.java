package com.registro.registroelettronico.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomeworkResponseDTO {

    private UUID id;
    private UUID subjectClassId;
    private String message;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
}
