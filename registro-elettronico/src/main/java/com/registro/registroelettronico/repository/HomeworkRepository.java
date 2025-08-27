package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository for Homework entities.
 */
@Repository
public interface HomeworkRepository extends JpaRepository<Homework, UUID> {
}