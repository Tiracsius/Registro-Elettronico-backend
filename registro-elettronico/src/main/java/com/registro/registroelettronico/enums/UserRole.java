package com.registro.registroelettronico.enums;

/**
 * Enumeration of the different roles a user may assume within
 * the electronic register system. These roles drive access control
 * throughout the application. Using an enum instead of hard‑coded
 * strings helps avoid typos and eases refactoring.
 */
public enum UserRole {
    /**
     * Role for students. Students can view their own grades, presence
     * records and receive homework and notes from teachers.
     */
    STUDENT,

    /**
     * Role for parents. Parents can view information related to their
     * children (students) such as grades and presence records and can
     * communicate with teachers.
     */
    PARENT,

    /**
     * Role for teachers. Teachers can manage grades, presence records,
     * homework, tests and interact with students and parents.
     */
    TEACHER,

    /**
     * Role for secretary or administrative staff. Secretaries can manage
     * classes, schedules and other administrative tasks.
     */
    SECRETARY
}