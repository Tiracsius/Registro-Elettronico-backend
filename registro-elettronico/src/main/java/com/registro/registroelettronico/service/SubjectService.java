package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.Subject;
import com.registro.registroelettronico.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing CRUD operations for subjects.
 */
@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository repository;

    public List<Subject> getAll() {
        return repository.findAll();
    }

    public Subject getById(java.util.UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Subject not found with id " + id));
    }

    public Subject create(Subject subject) {
        return repository.save(subject);
    }

    public Subject update(java.util.UUID id, Subject data) {
        Subject existing = getById(id);
        existing.setName(data.getName());
        return repository.save(existing);
    }

    public void delete(java.util.UUID id) {
        repository.deleteById(id);
    }
}