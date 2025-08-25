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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /** A unique identifier associated with the student (e.g. fiscal code). */
    @Column(nullable = false, unique = true)
    private String cardId;

    /**
     * Many students can share the same parent. This association is
     * optional because some students may not have a parent defined in the
     * system (e.g. of legal age).
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ParentInfo parent;
}