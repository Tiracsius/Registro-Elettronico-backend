package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.ScrutinioStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents the final evaluation of a student in a class. The
 * evaluation can be in different states (draft, finalized, approved)
 * depending on the workflow adopted by the institution.
 */
@Entity
@Table(name = "scrutinio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scrutinio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ScrutinioStatus status;

    private LocalDate date;

    /** The overall grade assigned to the student for the course. */
    private Double vote;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_class_id")
    private StudentClass studentClass;
}