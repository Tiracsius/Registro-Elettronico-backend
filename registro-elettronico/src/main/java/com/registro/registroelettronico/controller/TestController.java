package com.registro.registroelettronico.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.registro.registroelettronico.dto.TestRequestDTO;
import com.registro.registroelettronico.dto.TestResponseDTO;
import com.registro.registroelettronico.service.TestService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestController {
	
	private final TestService testService;

	
	@GetMapping("/subjectclass/{subjectClassId}")
	public ResponseEntity<TestResponseDTO> getTestBySubjectClass(@PathVariable UUID subjectClassId, @RequestParam("date") LocalDate date) {
		return ResponseEntity.ok(testService.getTestByDateAndSubjectClassId(date, subjectClassId));
	}
	
	@GetMapping("/class/{classId}")
	public ResponseEntity<List<TestResponseDTO>> getAllTestsByClassId(@PathVariable UUID classId, @RequestParam("date") LocalDate date) {
		return ResponseEntity.ok(testService.getTestByDateAndClassId(date, classId));
	}
	
	@PostMapping
	public ResponseEntity<Void> createTest(@Valid @RequestBody TestRequestDTO request) {
		testService.createTest(request);
		return ResponseEntity.ok().build();
	}
}
