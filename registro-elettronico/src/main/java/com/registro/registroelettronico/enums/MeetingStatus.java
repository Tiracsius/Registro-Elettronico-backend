package com.registro.registroelettronico.enums;

/**
 * Status values for a meeting request between parents and teachers.
 */
public enum MeetingStatus {
    /** The meeting has been requested and awaits confirmation. */
    PENDING,
    /** The meeting has been accepted by the teacher. */
    CONFIRMED,
    /** The meeting has been cancelled by either party. */
    CANCELLED
}