package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.AuthRequest;
import com.registro.registroelettronico.dto.AuthResponse;
import com.registro.registroelettronico.dto.UserRequestDTO;

public interface AuthService {

    public void register(UserRequestDTO request);
    public AuthResponse authenticate(AuthRequest request);
}
