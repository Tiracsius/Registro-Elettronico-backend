package com.registro.registroelettronico.repository;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.registroelettronico.entity.SchoolClass;

/**
 * Repository for SchoolClass entities.
 */
@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, UUID> {
	boolean existsByYearStart(LocalDate yearStart);
}