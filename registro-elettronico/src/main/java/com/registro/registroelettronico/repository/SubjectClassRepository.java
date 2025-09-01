package com.registro.registroelettronico.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.registroelettronico.entity.SubjectClass;

/**
 * Repository for SubjectClass entities.
 */
@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, UUID> {
	
	@EntityGraph(attributePaths = {"subject", "schoolClass", "teacher"})
	List<SubjectClass> findAllByTeacherId(UUID id);
}