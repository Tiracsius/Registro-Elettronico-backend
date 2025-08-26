package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for SchoolClass entities.
 */
@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, java.util.UUID> {
}