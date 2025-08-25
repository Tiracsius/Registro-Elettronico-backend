package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a teacher employed by the school. Teachers can teach
 * multiple subjects across multiple classes via the SubjectClass
 * entity.
 */
@Entity
@Table(name = "teacher_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /** A unique identifier associated with the teacher (e.g. fiscal code). */
    @Column(nullable = false, unique = true)
    private String cardId;
}