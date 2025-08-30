package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.UserRequestDTO;
import com.registro.registroelettronico.entity.Credential;

public interface CredentialGeneratorService {

    public Credential generateNewCredential(UserRequestDTO request);

}
