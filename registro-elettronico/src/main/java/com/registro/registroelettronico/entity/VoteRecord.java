package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents a grade assigned to a student for a specific subject
 * lesson or test. Each record links a student to a subject through
 * their class association.
 */
@Entity
@Table(name = "vote_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Numeric representation of the grade (e.g. 6.5). */
    private Double vote;

    /** Date when the grade was recorded. */
    private LocalDate date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_class_id")
    private StudentClass studentClass;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;
}