package com.registro.registroelettronico.entity;

import com.registro.registroelettronico.enums.MeetingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents a scheduled meeting (colloquio) between a parent and a
 * teacher for a specific subject and class. Meetings can have
 * different statuses such as pending, confirmed or cancelled.
 */
@Entity
@Table(name = "meeting")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private ParentInfo parent;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_class_id")
    private SubjectClass subjectClass;

    @Enumerated(EnumType.STRING)
    private MeetingStatus status;

    /** Scheduled date for the meeting. */
    private LocalDate dueDate;
}