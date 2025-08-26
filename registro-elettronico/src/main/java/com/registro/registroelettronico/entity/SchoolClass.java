package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a class or section within the school. A class groups
 * students together and has a start and end year. The name could
 * represent the section (e.g. "1A").
 */
@Entity
@Table(name = "school_class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    @Column(nullable = false)
    private String name;

    /**
     * The starting academic year for this class (e.g. 2024 for the
     * 2024/2025 school year).
     */
    private LocalDate yearStart;

    /**
     * The ending academic year for this class (e.g. 2025 for the
     * 2024/2025 school year). It can be null when the class is ongoing.
     */
    private LocalDate yearEnd;

    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    private List<SubjectClass> subjects;
}