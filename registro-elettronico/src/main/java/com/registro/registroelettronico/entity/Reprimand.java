package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a disciplinary note assigned to a student. Each
 * reprimand is linked to a student through their class association
 * and optionally to a specific subject.
 */
@Entity
@Table(name = "reprimand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reprimand {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentInfo student;

    /** Short title summarizing the reason for the reprimand. */
    private String title;

    /** Detailed description of the incident or behaviour. */
    @Column(columnDefinition = "TEXT")
    private String message;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    private LocalDateTime createdAt;
}