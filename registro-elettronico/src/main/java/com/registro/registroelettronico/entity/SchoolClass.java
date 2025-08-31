package com.registro.registroelettronico.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.registro.registroelettronico.enums.SchoolClassLabel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SchoolClassLabel name;

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

    @OneToMany(mappedBy = "schoolClass", fetch = FetchType.LAZY)
    private List<StudentInfo> students;
}