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
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    @Enumerated(EnumType.STRING)
    private com.registro.registroelettronico.enums.PresenceStatus status;

    /** Date of the attendance record. */
    private java.time.LocalDate date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentInfo student;
}