package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for Subject entities.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {
}