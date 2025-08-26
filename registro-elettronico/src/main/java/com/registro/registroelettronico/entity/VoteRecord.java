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
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    /** Numeric representation of the grade (e.g. 6.5). */
    private Double vote;

    /** Date when the grade was recorded. */
    private java.time.LocalDate date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentInfo student;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;
}