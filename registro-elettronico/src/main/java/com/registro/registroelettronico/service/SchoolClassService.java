package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.repository.SchoolClassRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing CRUD operations for school classes.
 */
@Service
@RequiredArgsConstructor
public class SchoolClassService {

    private final SchoolClassRepository repository;

    public List<SchoolClass> getAll() {
        return repository.findAll();
    }

    public SchoolClass getById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Class not found with id " + id));
    }

    public SchoolClass create(SchoolClass c) {
        return repository.save(c);
    }

    public SchoolClass update(Long id, SchoolClass data) {
        SchoolClass existing = getById(id);
        existing.setName(data.getName());
        existing.setYearStart(data.getYearStart());
        existing.setYearEnd(data.getYearEnd());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}