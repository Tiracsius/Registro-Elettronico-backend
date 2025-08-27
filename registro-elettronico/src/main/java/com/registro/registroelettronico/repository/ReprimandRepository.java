package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Reprimand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for Reprimand entities.
 */
@Repository
public interface ReprimandRepository extends JpaRepository<Reprimand, UUID> {
}