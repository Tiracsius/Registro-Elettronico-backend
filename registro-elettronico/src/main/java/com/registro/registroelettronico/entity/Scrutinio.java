package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.ScrutinioStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents the final evaluation of a student in a class. The
 * evaluation can be in different states (draft, finalized, approved)
 * depending on the workflow adopted by the institution.
 */
@Entity
@Table(name = "scrutinio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scrutinio {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    @Enumerated(EnumType.STRING)
    private com.registro.registroelettronico.enums.ScrutinioStatus status;

    private java.time.LocalDate date;

    /** The overall grade assigned to the student for the course. */
    private Double vote;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentInfo student;

    /** The subject class for which the final evaluation is recorded. */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;
}