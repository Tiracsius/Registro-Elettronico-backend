package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for TestEntity entities.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, java.util.UUID> {
}