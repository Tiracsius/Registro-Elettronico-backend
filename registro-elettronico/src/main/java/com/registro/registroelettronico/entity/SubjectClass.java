package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Associates a subject with a class and a teacher. This mapping allows
 * the same subject to be taught by different teachers across different
 * classes.
 */
@Entity
@Table(name = "subject_class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private TeacherInfo teacher;
}