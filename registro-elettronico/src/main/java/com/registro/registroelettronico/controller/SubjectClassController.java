package com.registro.registroelettronico.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registro.registroelettronico.dto.SubjectClassResponseDTO;
import com.registro.registroelettronico.service.SubjectClassService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subjectclass")
@RequiredArgsConstructor
public class SubjectClassController {
	
	private final SubjectClassService subjectClassService;
	
	
	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<List<SubjectClassResponseDTO>> getAllSubjectClassByTeacherId(@PathVariable UUID teacherId) {
		return ResponseEntity.ok(subjectClassService.getAllSubjectClassByTeacherId(teacherId));
	}
}
