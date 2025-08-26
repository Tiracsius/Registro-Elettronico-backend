package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Represents a justification provided by a parent for a student's
 * absence. A justification is linked to a specific presence record
 * and can be reviewed by the administration.
 */
@Entity
@Table(name = "justification")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Justification {
    @Id
    @GeneratedValue(generator = "UUID")
    @org.hibernate.annotations.GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private java.util.UUID id;

    // No direct reference to a parent is stored. The parent who submits a
    // justification can be inferred via the associated presence record and
    // student relationship.

    @Column(columnDefinition = "TEXT")
    private String message;

    /** Timestamp when the justification was created. */
    private java.time.LocalDateTime createdAt;

    /** The presence record this justification refers to. */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "presence_record_id")
    private PresenceRecord presenceRecord;
}