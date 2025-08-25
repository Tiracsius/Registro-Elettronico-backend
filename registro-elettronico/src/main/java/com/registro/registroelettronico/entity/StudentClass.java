package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Links a student to a class. A student may move between classes
 * across academic years, so we store the relation separately from
 * StudentInfo and SchoolClass. Additional fields like enrollment
 * dates could be added here if needed.
 */
@Entity
@Table(name = "student_class")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentInfo student;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}