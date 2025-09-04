package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.PresenceRecordRequestDTO;
import com.registro.registroelettronico.dto.PresenceRecordResponseDTO;
import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.enums.PresenceStatus;
import com.registro.registroelettronico.service.PresenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller exposing endpoints to manage presence (attendance) records.
 */
@RestController
@RequestMapping("/api/presences")
@RequiredArgsConstructor
public class PresenceController {

    private final PresenceService presenceService;

    @GetMapping("/class/{classId}")
    public ResponseEntity<List<PresenceRecordResponseDTO>> getAllPresenceRecordsByClassId(@PathVariable UUID classId) {
        return ResponseEntity.ok(presenceService.getAllPresenceRecordsByClassId(classId));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<PresenceRecordResponseDTO>> getAllPresenceRecordsByStudentId(@PathVariable UUID studentId) {
        return ResponseEntity.ok(presenceService.getAllPresenceRecordByStudentId(studentId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable  UUID id, @RequestParam(required = true)PresenceStatus status) {
        presenceService.updatePresenceRecord(id, status);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createPresenceRecords(@RequestBody List<PresenceRecordRequestDTO> presenceRecords) {
        presenceService.createPresenceRecord(presenceRecords);
        return ResponseEntity.ok().build();
    }
}