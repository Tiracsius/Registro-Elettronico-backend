package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for TestEntity entities.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {
}