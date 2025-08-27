package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Scrutinio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for Scrutinio entities.
 */
@Repository
public interface ScrutinioRepository extends JpaRepository<Scrutinio, UUID> {
}