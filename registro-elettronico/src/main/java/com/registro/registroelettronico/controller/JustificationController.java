package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.JustificationRequestDTO;
import com.registro.registroelettronico.dto.JustificationResponseDTO;
import com.registro.registroelettronico.dto.PresenceRecordResponseDTO;
import com.registro.registroelettronico.service.JustificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/justifications")
public class JustificationController {

    private final JustificationService justficationService;

    @GetMapping("/presenceRecord/{presenceRecordId}")
    public ResponseEntity<JustificationResponseDTO> getJustificationByPresenceRecord(@PathVariable UUID presenceRecordId) {
        return ResponseEntity.ok(justficationService.getJustificationByPresenceRecordId(presenceRecordId));
    }

    @PostMapping
    public ResponseEntity<Void> createJustification(@Valid @RequestBody JustificationRequestDTO request) {
        justficationService.createJustification(request);
        return ResponseEntity.ok().build();
    }
}
