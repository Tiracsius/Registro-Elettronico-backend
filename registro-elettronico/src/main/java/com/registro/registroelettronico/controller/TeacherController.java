package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage teachers.
 */
@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService service;

    @GetMapping
    public ResponseEntity<List<TeacherInfo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherInfo> getById(@PathVariable java.util.UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherInfo> create(@RequestBody TeacherInfo teacher) {
        return ResponseEntity.ok(service.create(teacher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherInfo> update(@PathVariable java.util.UUID id, @RequestBody TeacherInfo data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable java.util.UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}