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

import com.registro.registroelettronico.dto.LessonRecordRequestDTO;
import com.registro.registroelettronico.dto.LessonRecordResponseDTO;
import com.registro.registroelettronico.service.LessonRecordService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonRecordController {
	
	private final LessonRecordService lessonRecordService;
	
	@GetMapping("/subjectclass/{subjectClassId}")
	public ResponseEntity<LessonRecordResponseDTO> getLessonRecordBySubjectClass(@PathVariable UUID subjectClassId, @RequestParam("date") LocalDate date) {
		return ResponseEntity.ok(lessonRecordService.getLessonRecordByDateAndSubjectClassId(date, subjectClassId));
	}
	
	@GetMapping("/class/{classId}")
	public ResponseEntity<List<LessonRecordResponseDTO>> getLessonRecordByClass(@PathVariable UUID classId, @RequestParam("date") LocalDate date) {
		return ResponseEntity.ok(lessonRecordService.getLessonRecordByDateAndClassId(date, classId));
	}
	
	@PostMapping
	public ResponseEntity<Void> createLessonRecord(@Valid @RequestBody LessonRecordRequestDTO request) {
		lessonRecordService.createLessonRecord(request);
		return ResponseEntity.ok().build();
	}
}
