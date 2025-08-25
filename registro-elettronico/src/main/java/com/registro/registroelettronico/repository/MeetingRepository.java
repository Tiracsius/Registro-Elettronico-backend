package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Meeting entities.
 */
@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}