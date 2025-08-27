package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.PresenceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for PresenceRecord entities.
 */
@Repository
public interface PresenceRecordRepository extends JpaRepository<PresenceRecord, UUID> {
}