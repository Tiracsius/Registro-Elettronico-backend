package com.registro.registroelettronico.enums;

/**
 * Represents how often a scheduled lesson occurs. This helps the
 * application handle recurring events such as weekly lessons or
 * alternating schedules.
 */
public enum Frequency {
    /** Occurs every day the class is scheduled. */
    DAILY,
    /** Occurs once per week. */
    WEEKLY,
    /** Occurs every other week. */
    BIWEEKLY,
    /** Occurs once per month. */
    MONTHLY
}