package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller exposing endpoints to manage students.
 */
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<UserResponseDTO>> getAllStudentsBySchoolClassId(@PathVariable UUID classId) {
        return ResponseEntity.ok(studentService.getAllStudentsByClassId(classId));
    }
}