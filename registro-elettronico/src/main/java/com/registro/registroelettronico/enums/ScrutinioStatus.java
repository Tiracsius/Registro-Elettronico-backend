package com.registro.registroelettronico.enums;

/**
 * Enumerates the possible states of a final grade summary (scrutinio).
 * Using an enum clarifies the domain logic compared to raw strings.
 */
public enum ScrutinioStatus {
    /** The grades are provisional and subject to change. */
    DRAFT,
    /** The grades have been confirmed by the teachers and are final. */
    FINALIZED,
    /** The grades have been formally approved by the administration. */
    APPROVED
}