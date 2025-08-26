package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.service.PresenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage presence (attendance) records.
 */
@RestController
@RequestMapping("/api/presences")
@RequiredArgsConstructor
public class PresenceController {

    private final PresenceService service;

    @GetMapping
    public ResponseEntity<List<PresenceRecord>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresenceRecord> getById(@PathVariable java.util.UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<PresenceRecord> create(@RequestBody PresenceRecord record) {
        return ResponseEntity.ok(service.create(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PresenceRecord> update(@PathVariable java.util.UUID id, @RequestBody PresenceRecord data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable java.util.UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}