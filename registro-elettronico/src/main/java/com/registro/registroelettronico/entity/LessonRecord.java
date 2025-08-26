package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Records what happened during a lesson. Teachers can use this
 * entity to document topics covered, notes for absent students and
 * any relevant information about the session.
 */
@Entity
@Table(name = "lesson_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonRecord {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    /**
     * Free text describing the content of the lesson. This can include
     * topics covered, exercises solved and any announcements.
     */
    @Column(columnDefinition = "TEXT")
    private String message;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "day_event_id")
    private DayEvent dayEvent;

    /** Timestamp when the record was created. */
    private java.time.LocalDateTime createdAt;
}