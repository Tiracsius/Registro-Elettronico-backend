package com.registro.registroelettronico.service;

import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.repository.ParentInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service providing CRUD operations for parents.
 */
@Service
@RequiredArgsConstructor
public class ParentService {

    private final ParentInfoRepository repository;

    public List<ParentInfo> getAll() {
        return repository.findAll();
    }

    public ParentInfo getById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Parent not found with id " + id));
    }

    public ParentInfo create(ParentInfo parent) {
        return repository.save(parent);
    }

    public ParentInfo update(Long id, ParentInfo data) {
        ParentInfo existing = getById(id);
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