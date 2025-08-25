package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a member of the administrative staff. Secretaries are
 * responsible for managing classes, schedules and other tasks.
 */
@Entity
@Table(name = "secretary_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecretaryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /** A unique identifier associated with the secretary (e.g. fiscal code). */
    @Column(nullable = false, unique = true)
    private String cardId;
}