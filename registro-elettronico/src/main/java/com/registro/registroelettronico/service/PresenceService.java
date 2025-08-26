package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.repository.PresenceRecordRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for managing presence (attendance) records.
 */
@Service
@RequiredArgsConstructor
public class PresenceService {

    private final PresenceRecordRepository repository;

    public List<PresenceRecord> getAll() {
        return repository.findAll();
    }

    public PresenceRecord getById(java.util.UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Presence record not found with id " + id));
    }

    public PresenceRecord create(PresenceRecord record) {
        return repository.save(record);
    }

    public PresenceRecord update(java.util.UUID id, PresenceRecord data) {
        PresenceRecord existing = getById(id);
        existing.setDate(data.getDate());
        existing.setStatus(data.getStatus());
        existing.setStudent(data.getStudent());
        return repository.save(existing);
    }

    public void delete(java.util.UUID id) {
        repository.deleteById(id);
    }
}