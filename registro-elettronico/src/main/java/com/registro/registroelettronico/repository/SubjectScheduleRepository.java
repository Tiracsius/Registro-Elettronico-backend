package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.SubjectSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for SubjectSchedule entities.
 */
@Repository
public interface SubjectScheduleRepository extends JpaRepository<SubjectSchedule, Long> {
}