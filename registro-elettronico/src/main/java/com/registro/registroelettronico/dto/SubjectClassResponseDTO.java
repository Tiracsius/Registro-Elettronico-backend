package com.registro.registroelettronico.dto;

import java.util.UUID;

public record SubjectClassResponseDTO(
    UUID id,
    ClassSummaryDTO schoolClass,
    SubjectSummaryDTO subject,
    TeacherSummaryDTO teacher
) {}
