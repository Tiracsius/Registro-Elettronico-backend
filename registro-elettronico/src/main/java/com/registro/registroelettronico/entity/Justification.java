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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ParentInfo parent;

    @Column(columnDefinition = "TEXT")
    private String message;

    /** Timestamp when the justification was created. */
    private LocalDateTime createdAt;

    /** The presence record this justification refers to. */
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "presence_record_id")
    private PresenceRecord presenceRecord;
}