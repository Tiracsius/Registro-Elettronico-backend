package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.entity.StudentInfo;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Repository for PresenceRecord entities.
 */
@Repository
public interface PresenceRecordRepository extends JpaRepository<PresenceRecord, UUID> {

    @EntityGraph(attributePaths = {"student"})
    public List<PresenceRecord> findByStudent_SchoolClass_IdAndCreatedAt(UUID classId, LocalDate createdAt);
    @EntityGraph(attributePaths = {"student"})
    public List<PresenceRecord> findAllByStudent(StudentInfo student);
}