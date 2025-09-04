package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.ReprimandRequestDTO;
import com.registro.registroelettronico.dto.ReprimandResponseDTO;
import com.registro.registroelettronico.service.ReprimandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ReprimandController {

    private final ReprimandService reprimandService;


    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ReprimandResponseDTO>> getAllReprimandsByStudent(@PathVariable UUID studentId) {
        return ResponseEntity.ok(reprimandService.getAllReprimandsByStudentId(studentId));
    }

    @PostMapping
    public ResponseEntity<Void> createReprimand(@Valid @RequestBody ReprimandRequestDTO request) {
        reprimandService.createReprimand(request);
        return ResponseEntity.ok().build();
    }
}
