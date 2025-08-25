package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.service.SchoolClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage school classes.
 */
@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {

    private final SchoolClassService service;

    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClass> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<SchoolClass> create(@RequestBody SchoolClass schoolClass) {
        return ResponseEntity.ok(service.create(schoolClass));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolClass> update(@PathVariable Long id, @RequestBody SchoolClass data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}