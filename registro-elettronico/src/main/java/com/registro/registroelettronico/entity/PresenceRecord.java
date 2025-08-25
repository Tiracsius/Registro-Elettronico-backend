package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.PresenceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Tracks a student's presence or absence for a given day. Presence
 * records are linked to a student via their class association.
 */
@Entity
@Table(name = "presence_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PresenceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PresenceStatus status;

    /** Date of the attendance record. */
    private LocalDate date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_class_id")
    private StudentClass studentClass;
}