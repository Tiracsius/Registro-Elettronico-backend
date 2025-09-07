package com.registro.registroelettronico.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.registroelettronico.entity.Test;

/**
 * Repository for TestEntity entities.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {
	@EntityGraph(attributePaths = {"subjectClass"})
	Optional<Test> findFirstByDueDateAndSubjectClass_Id(LocalDate date, UUID subjectClassId);
	@EntityGraph(attributePaths = {"subjectClass", "subjectClass.schoolClass"})
	List<Test> findAllByDueDateAndSubjectClass_SchoolClass_Id(LocalDate date, UUID classId);
}