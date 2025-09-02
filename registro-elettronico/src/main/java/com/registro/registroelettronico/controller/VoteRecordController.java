package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.VoteRecordRequestDTO;
import com.registro.registroelettronico.dto.VoteRecordResponseDTO;
import com.registro.registroelettronico.service.VoteRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/votes")
@RequiredArgsConstructor
public class VoteRecordController {

    private final VoteRecordService voteRecordService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<VoteRecordResponseDTO>> getAllVoteRecordsByStudentId(@PathVariable UUID studentId) {
        return ResponseEntity.ok(voteRecordService.getAllVoteRecordByStudentId(studentId));
    }

    @GetMapping("/student/{studentId}/subject/{subjectClassId}")
    public ResponseEntity<List<VoteRecordResponseDTO>> getAllVoteRecordsByStudentIdAndSubjectId(@PathVariable UUID studentId, @PathVariable UUID subjectClassId) {
        return ResponseEntity.ok(voteRecordService.getAllVoteRecordByStudentIdAndSubjectClassId(studentId, subjectClassId));
    }

    @PostMapping
    public ResponseEntity<Void> createVoteRecord(@Valid @RequestBody VoteRecordRequestDTO request) {
        voteRecordService.createVoteRecord(request);
        return ResponseEntity.ok().build();
    }
}
