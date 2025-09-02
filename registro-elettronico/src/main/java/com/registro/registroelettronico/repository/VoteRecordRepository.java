package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.VoteRecord;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository for VoteRecord entities.
 */
@Repository
public interface VoteRecordRepository extends JpaRepository<VoteRecord, UUID> {

    @EntityGraph(attributePaths = {"subjectClass", "subjectClass.subject"})
    public List<VoteRecord> findAllByStudentId(UUID id);

    @EntityGraph(attributePaths = {"subjectClass", "subjectClass.subject"})
    public List<VoteRecord> findAllByStudentIdAndSubjectClassId(UUID studentId, UUID subjectClassId);
}