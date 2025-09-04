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
public class ReprimandResponseDTO {

    private String title;
    private String message;
    private UUID id;
    private StudentSummaryDTO student;
    private SubjectClassResponseDTO subjectClass;
    private LocalDateTime createdAt;

}
