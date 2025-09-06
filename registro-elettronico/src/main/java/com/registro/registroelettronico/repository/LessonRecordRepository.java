package com.registro.registroelettronico.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.registroelettronico.entity.LessonRecord;

/**
 * Repository for LessonRecord entities.
 */
@Repository
public interface LessonRecordRepository extends JpaRepository<LessonRecord, UUID> {
	
	@EntityGraph(attributePaths = {"subjectClass"})
	Optional<LessonRecord> findFirstByCreatedAtBetweenAndSubjectClass_Id(LocalDateTime start, LocalDateTime end, UUID subjectClassId);
	@EntityGraph(attributePaths = {"subjectClass", "subjectClass.schoolClass"})
	List<LessonRecord> findAllByCreatedAtBetweenAndSubjectClassSchoolClass_Id(LocalDateTime start, LocalDateTime end, UUID classId);

}