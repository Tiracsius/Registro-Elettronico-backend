package com.registro.registroelettronico.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Represents a day on which events such as lessons, tests or homework
 * assignments occur for a particular class. It groups various
 * records together for a given date and class.
 */
@Entity
@Table(name = "day_event")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Date of the event (no time component). */
    private LocalDate date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;
}