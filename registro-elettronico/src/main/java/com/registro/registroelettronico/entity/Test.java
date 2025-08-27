package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.TestType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents an assessment scheduled by a teacher. Each test is
 * associated with a subject class and recorded within a DayEvent.
 */
@Entity
@Table(name = "test")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    @Enumerated(EnumType.STRING)
    private TestType type;

    private LocalDate dueDate;

    /** Timestamp when the record was created. */
    private LocalDateTime createdAt;
}