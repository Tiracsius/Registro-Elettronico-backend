package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.TeacherInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for TeacherInfo entities.
 */
@Repository
public interface TeacherInfoRepository extends JpaRepository<TeacherInfo, UUID> {
	Optional<TeacherInfo> findByCredentialId(UUID id);
    boolean existsByEmail(String email);
}