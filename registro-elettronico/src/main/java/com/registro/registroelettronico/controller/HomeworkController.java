package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.HomeworkRequestDTO;
import com.registro.registroelettronico.dto.HomeworkResponseDTO;
import com.registro.registroelettronico.service.HomeworkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/homeworks")
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;

    @GetMapping("/subjectclass/{subjectClassId}")
    public ResponseEntity<HomeworkResponseDTO> getHomeworkBySubjectClassId(@PathVariable UUID subjectClassId, @RequestParam("date") LocalDate date) {
        return ResponseEntity.ok(homeworkService.getHomeworkByDueDateAndSubjectClassId(date, subjectClassId));
    }

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<HomeworkResponseDTO>> getHomeworkByClassId(@PathVariable UUID classId, @RequestParam("date") LocalDate date) {
        return ResponseEntity.ok(homeworkService.getAllHomeworkByDueDateAndClassId(date, classId));
    }

    @PostMapping
    public ResponseEntity<Void> createHomework(@Valid @RequestBody HomeworkRequestDTO request) {
        homeworkService.createHomework(request);
        return ResponseEntity.ok().build();
    }
}
