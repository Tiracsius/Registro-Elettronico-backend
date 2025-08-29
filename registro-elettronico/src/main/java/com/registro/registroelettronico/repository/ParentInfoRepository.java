package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.ParentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for ParentInfo entities. Provides CRUD operations for
 * parents.
 */
@Repository
public interface ParentInfoRepository extends JpaRepository<ParentInfo, UUID> {

	Optional<ParentInfo> findByCredentialId(UUID id);
}
