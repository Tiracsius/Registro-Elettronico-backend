package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a homework assignment given by a teacher. Homework is
 * associated with a subject class and optionally linked to a day
 * event (e.g. the date it was assigned).
 */
@Entity
@Table(name = "homework")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    /** Description of the homework. */
    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDate dueDate;

    /** Timestamp when the record was created. */
    private LocalDateTime createdAt;
}