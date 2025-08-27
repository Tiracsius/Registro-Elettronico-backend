package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.LessonRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for LessonRecord entities.
 */
@Repository
public interface LessonRecordRepository extends JpaRepository<LessonRecord, UUID> {
}