package com.registro.registroelettronico.enums;

/**
 * Different types of assessments a teacher can assign. This allows
 * us to distinguish between oral examinations, written tests and
 * practical assessments when recording test results.
 */
public enum TestType {
    /** Oral examination. */
    ORAL,
    /** Written examination. */
    WRITTEN,
    /** Practical or laboratory based assessment. */
    PRACTICAL
}