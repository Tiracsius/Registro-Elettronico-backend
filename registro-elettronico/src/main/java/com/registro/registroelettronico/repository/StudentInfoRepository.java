package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for StudentInfo entities.
 */
@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, UUID> {
}