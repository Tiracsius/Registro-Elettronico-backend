package com.registro.registroelettronico.repository;

import com.registro.registroelettronico.entity.Justification;
import com.registro.registroelettronico.entity.PresenceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository for Justification entities.
 */
@Repository
public interface JustificationRepository extends JpaRepository<Justification, UUID> {

    Optional<Justification> findByPresenceRecord(PresenceRecord presenceRecord);
}