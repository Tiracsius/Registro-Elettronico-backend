package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.DayEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for DayEvent entities.
 */
@Repository
public interface DayEventRepository extends JpaRepository<DayEvent, Long> {
}