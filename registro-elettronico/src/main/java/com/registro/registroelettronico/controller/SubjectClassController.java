package com.registro.registroelettronico.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


	@GetMapping("/class/{classId}")
	public ResponseEntity<List<SubjectClassResponseDTO>> getAllSubjectClassByClassId(@PathVariable UUID classId) {
		return ResponseEntity.ok(subjectClassService.getAllSubjectClassByClassId(classId));
	}

	@PutMapping("/{subjectClassId}/teacher/{teacherId}")
	public ResponseEntity<Void> assignTeacherToSubjectClassById(@PathVariable UUID subjectClassId, @PathVariable UUID teacherId) {
		subjectClassService.updateSubjectClassById(subjectClassId, teacherId);
		return ResponseEntity.ok().build();
	}
}
