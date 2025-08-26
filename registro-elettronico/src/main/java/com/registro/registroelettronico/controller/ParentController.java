package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage parents.
 */
@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService service;

    @GetMapping
    public ResponseEntity<List<ParentInfo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentInfo> getById(@PathVariable java.util.UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<ParentInfo> create(@RequestBody ParentInfo parent) {
        return ResponseEntity.ok(service.create(parent));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentInfo> update(@PathVariable java.util.UUID id, @RequestBody ParentInfo data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable java.util.UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}