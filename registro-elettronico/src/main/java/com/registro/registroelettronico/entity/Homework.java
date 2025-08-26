package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    /** Description of the homework. */
    @Column(columnDefinition = "TEXT")
    private String message;

    /** Deadline for submitting the homework. */
    private java.time.LocalDate deadline;

    /** The day event on which this homework was assigned. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_event_id")
    private DayEvent dayEvent;
}