package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.repository.StudentInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing CRUD operations for students.
 */
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentInfoRepository repository;

    public List<StudentInfo> getAll() {
        return repository.findAll();
    }

    public StudentInfo getById(java.util.UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Student not found with id " + id));
    }

    public StudentInfo create(StudentInfo student) {
        return repository.save(student);
    }

    public StudentInfo update(java.util.UUID id, StudentInfo data) {
        StudentInfo existing = getById(id);
        existing.setFirstName(data.getFirstName());
        existing.setLastName(data.getLastName());
        existing.setEmail(data.getEmail());
        existing.setParent(data.getParent());
        existing.setSchoolClass(data.getSchoolClass());
        existing.setEnrollmentDate(data.getEnrollmentDate());
        return repository.save(existing);
    }

    public void delete(java.util.UUID id) {
        repository.deleteById(id);
    }
}