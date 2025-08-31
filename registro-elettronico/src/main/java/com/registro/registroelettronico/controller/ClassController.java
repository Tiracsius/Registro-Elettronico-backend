package com.registro.registroelettronico.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.registroelettronico.dto.SchoolClassResponseDTO;
import com.registro.registroelettronico.service.SchoolClassService;

import lombok.RequiredArgsConstructor;

/**
 * REST controller exposing endpoints to manage school classes.
 */
@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassController {

    private final SchoolClassService schoolClassservice;

    @GetMapping
    public ResponseEntity<List<SchoolClassResponseDTO>> getAllSchoolClasses() {
        return ResponseEntity.ok(schoolClassservice.getAllSchoolClasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolClassResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(schoolClassservice.getSchoolClassById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create() {
    	schoolClassservice.createSchoolClasses();
        return ResponseEntity.ok().build();
    }

}