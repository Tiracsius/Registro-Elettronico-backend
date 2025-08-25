package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /** A unique identifier associated with the parent (e.g. fiscal code). */
    @Column(nullable = false, unique = true)
    private String cardId;
}