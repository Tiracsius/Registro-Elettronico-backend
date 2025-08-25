package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.repository.TeacherInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing CRUD operations for teachers.
 */
@Service
@RequiredArgsConstructor
public class TeacherService {

    @Autowired
    private TeacherInfoRepository repository;

    public List<TeacherInfo> getAll() {
        return repository.findAll();
    }

    public TeacherInfo getById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Teacher not found with id " + id));
    }

    public TeacherInfo create(TeacherInfo teacher) {
        return repository.save(teacher);
    }

    public TeacherInfo update(Long id, TeacherInfo data) {
        TeacherInfo existing = getById(id);
        existing.setFirstName(data.getFirstName());
        existing.setLastName(data.getLastName());
        existing.setEmail(data.getEmail());
        existing.setCardId(data.getCardId());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}