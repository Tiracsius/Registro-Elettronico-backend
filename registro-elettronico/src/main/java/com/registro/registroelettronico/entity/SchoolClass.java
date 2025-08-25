package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Represents a class or section within the school. A class groups
 * students together and has a start and end year. The name could
 * represent the section (e.g. "1A").
 */
@Entity
@Table(name = "class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    /**
     * The starting academic year for this class (e.g. 2024 for the
     * 2024/2025 school year).
     */
    private Integer yearStart;

    /**
     * The ending academic year for this class (e.g. 2025 for the
     * 2024/2025 school year). It can be null when the class is ongoing.
     */
    private Integer yearEnd;
}