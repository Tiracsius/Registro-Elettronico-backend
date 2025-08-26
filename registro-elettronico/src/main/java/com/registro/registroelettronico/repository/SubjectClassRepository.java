package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.SubjectClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for SubjectClass entities.
 */
@Repository
public interface SubjectClassRepository extends JpaRepository<SubjectClass, java.util.UUID> {
}