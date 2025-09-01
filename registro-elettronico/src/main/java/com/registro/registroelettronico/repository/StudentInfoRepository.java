package com.registro.registroelettronico.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.registroelettronico.entity.StudentInfo;

/**
 * Repository for StudentInfo entities.
 */
@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, UUID> {
	Optional<StudentInfo> findByCredentialId(UUID credentialId);
    boolean existsByEmail(String email);
    List<StudentInfo> findAllBySchoolClassId(UUID classId);
}