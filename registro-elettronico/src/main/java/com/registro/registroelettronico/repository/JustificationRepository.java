package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Justification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Justification entities.
 */
@Repository
public interface JustificationRepository extends JpaRepository<Justification, java.util.UUID> {
}