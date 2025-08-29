package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.SecretaryInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for SecretaryInfo entities.
 */
@Repository
public interface SecretaryInfoRepository extends JpaRepository<SecretaryInfo, UUID> {

	Optional<SecretaryInfo> findByCredentialId(UUID id);
}