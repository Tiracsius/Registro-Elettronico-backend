package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.SubjectSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for SubjectSchedule entities.
 */
@Repository
public interface SubjectScheduleRepository extends JpaRepository<SubjectSchedule, UUID> {
}