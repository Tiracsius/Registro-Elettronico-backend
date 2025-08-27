package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.VoteRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for VoteRecord entities.
 */
@Repository
public interface VoteRecordRepository extends JpaRepository<VoteRecord, UUID> {
}