package com.registro.registroelettronico.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class HomeworkRequestDTO {

    @NotNull(message = "Subject class ID is required")
    private UUID subjectClassId;

    @NotBlank(message = "Message is required")
    private String message;

    @NotNull(message = "Due date is required")
    @Future(message = "Due date must be in the future")
    private LocalDate dueDate;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
