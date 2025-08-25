package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for StudentClass mapping entities.
 */
@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
}