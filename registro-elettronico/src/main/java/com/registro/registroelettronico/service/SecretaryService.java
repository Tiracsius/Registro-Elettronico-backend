package com.registro.registroelettronico.service;

import java.util.UUID;

import com.registro.registroelettronico.dto.SecretaryRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;

public interface SecretaryService {
	
	public UserResponseDTO createSecretary(SecretaryRequestDTO secretary, Credential credential);
	public UserResponseDTO getSecretaryByCredentialId(UUID credentialId);
}
