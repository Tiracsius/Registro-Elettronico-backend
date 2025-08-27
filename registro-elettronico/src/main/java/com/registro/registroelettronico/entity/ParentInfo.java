package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * Stores parent or guardian information. A parent can be associated
 * with one or more students via the StudentInfo entity.
 */
@Entity
@Table(name = "parent_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParentInfo {
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
     * Credential used for authenticating the parent within the system.
     * Each parent has exactly one credential associated with them.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credential_id", unique = true)
    private Credential credential;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentInfo> students;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Meeting> meetings;
}