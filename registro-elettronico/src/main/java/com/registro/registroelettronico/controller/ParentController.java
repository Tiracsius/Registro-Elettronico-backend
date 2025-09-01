package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller exposing endpoints to manage parents.
 */
@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {

    private final ParentService parentInfoService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(parentInfoService.getAllParents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(parentInfoService.getParentById(id));
    }

}