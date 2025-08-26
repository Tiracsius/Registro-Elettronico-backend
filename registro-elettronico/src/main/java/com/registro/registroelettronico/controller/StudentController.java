package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage students.
 */
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentInfo>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentInfo> getById(@PathVariable java.util.UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<StudentInfo> create(@RequestBody StudentInfo student) {
        return ResponseEntity.ok(service.create(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentInfo> update(@PathVariable java.util.UUID id, @RequestBody StudentInfo data) {
        return ResponseEntity.ok(service.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable java.util.UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}