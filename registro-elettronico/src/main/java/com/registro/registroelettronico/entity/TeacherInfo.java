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
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Credential used for authenticating the teacher. Each teacher has one
     * credential, linking them to the login system.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id", unique = true)
    private Credential credential;
}