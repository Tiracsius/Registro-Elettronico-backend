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
public interface SchoolClassService {

    public List<SchoolClass> getAll();


    public SchoolClass getById(java.util.UUID id);

    public SchoolClass create();

    public SchoolClass update(java.util.UUID id, SchoolClass data);

    public void delete(java.util.UUID id);
}