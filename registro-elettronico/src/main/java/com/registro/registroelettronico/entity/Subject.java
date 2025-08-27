package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Represents a school subject (e.g. Mathematics, History). A subject
 * can be associated with multiple classes through SubjectClass.
 */
@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;
}