package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.TestType;
import jakarta.persistence.*;
import lombok.*;

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
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    @Enumerated(EnumType.STRING)
    private TestType type;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "day_event_id")
    private DayEvent dayEvent;
}