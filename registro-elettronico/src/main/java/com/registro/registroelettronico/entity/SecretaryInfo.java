package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Credential used for authenticating the secretary. Each secretary has
     * exactly one credential associated with them.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id", unique = true)
    private Credential credential;
}