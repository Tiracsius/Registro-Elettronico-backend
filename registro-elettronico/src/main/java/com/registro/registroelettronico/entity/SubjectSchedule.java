package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.Frequency;
import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Defines when a subject is taught for a given class. This allows
 * scheduling recurring lessons on specific days and times. The
 * frequency can be used for biweekly or other repeating patterns.
 */
@Entity
@Table(name = "subject_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectSchedule {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    /** Day of the week the lesson occurs (e.g. MONDAY). */
    @Enumerated(EnumType.STRING)
    private java.time.DayOfWeek day;

    /** Start time of the lesson. */
    private java.time.LocalTime hourStart;

    /** End time of the lesson. */
    private java.time.LocalTime hourEnd;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    /** How often this lesson recurs. */
    @Enumerated(EnumType.STRING)
    private com.registro.registroelettronico.enums.Frequency frequency;
}