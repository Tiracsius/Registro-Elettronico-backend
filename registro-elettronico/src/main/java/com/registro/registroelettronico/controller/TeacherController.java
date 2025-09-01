package com.registro.registroelettronico.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.service.TeacherService;

import lombok.RequiredArgsConstructor;

/**
 * REST controller exposing endpoints to manage teachers.
 */
@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeacher());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getTeacherById(@PathVariable UUID id) {
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

}