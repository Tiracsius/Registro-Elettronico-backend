package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.entity.Subject;
import com.registro.registroelettronico.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage subjects.
 */
@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService service;

    @GetMapping
    public ResponseEntity<List<Subject>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getById(@PathVariable java.util.UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<Subject> create(@RequestBody Subject subject) {
        return ResponseEntity.ok(service.create(subject));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> update(@PathVariable java.util.UUID id, @RequestBody Subject data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable java.util.UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}