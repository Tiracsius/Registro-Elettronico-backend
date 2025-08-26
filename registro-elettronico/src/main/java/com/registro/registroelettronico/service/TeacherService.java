package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.repository.TeacherInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing CRUD operations for teachers.
 */
@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherInfoRepository repository;

    public List<TeacherInfo> getAll() {
        return repository.findAll();
    }

    public TeacherInfo getById(java.util.UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Teacher not found with id " + id));
    }

    public TeacherInfo create(TeacherInfo teacher) {
        return repository.save(teacher);
    }

    public TeacherInfo update(java.util.UUID id, TeacherInfo data) {
        TeacherInfo existing = getById(id);
        existing.setFirstName(data.getFirstName());
        existing.setLastName(data.getLastName());
        existing.setEmail(data.getEmail());
        return repository.save(existing);
    }

    public void delete(java.util.UUID id) {
        repository.deleteById(id);
    }
}