package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a student enrolled in the school. Each student may
 * optionally have a parent associated with them.
 */
@Entity
@Table(name = "student_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentInfo {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    /** Student's given name. */
    @Column(nullable = false)
    private String firstName;

    /** Student's family name. */
    @Column(nullable = false)
    private String lastName;

    /** Contact email address. */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Date when the student enrolled in the school. This can be used
     * for historical queries and reporting.
     */
    private java.time.LocalDate enrollmentDate;

    /**
     * Many students can share the same parent. This association is
     * optional because some students may not have a parent defined in the
     * system (e.g. of legal age).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ParentInfo parent;

    /**
     * The class the student currently belongs to. A student can only be
     * enrolled in a single class at a time. If the student changes
     * classes, this field should be updated accordingly.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}