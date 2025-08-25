package com.registro.registroelettronico.enums;

/**
 * Represents the attendance status of a student for a particular day
 * or lesson. This enum is stored as a string in the database to
 * ensure readability and stability if the order of the constants
 * changes.
 */
public enum PresenceStatus {
    /** Student was present. */
    PRESENT,
    /** Student was absent without a justification. */
    ABSENT,
    /** Student was absent with an accepted justification. */
    EXCUSED
}