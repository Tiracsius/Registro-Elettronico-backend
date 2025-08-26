package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for {@link Credential} entities. Provides CRUD operations
 * and custom query methods to look up credentials by username.
 */
public interface CredentialRepository extends JpaRepository<Credential, UUID> {
    Optional<Credential> findByUsername(String username);
}