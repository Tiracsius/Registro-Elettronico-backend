package com.registro.registroelettronico.controller;

import com.registro.registroelettronico.dto.AuthRequest;
import com.registro.registroelettronico.dto.AuthResponse;
import com.registro.registroelettronico.dto.UserRequestDTO;
import com.registro.registroelettronico.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing authentication and registration endpoints.
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register( @Valid @RequestBody UserRequestDTO request) {
        authService.register(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}