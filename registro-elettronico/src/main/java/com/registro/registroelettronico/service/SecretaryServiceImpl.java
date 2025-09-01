package com.registro.registroelettronico.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.registro.registroelettronico.dto.SecretaryRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.SecretaryInfo;
import com.registro.registroelettronico.exception.SecretaryNotFoundException;
import com.registro.registroelettronico.mapper.SecretaryMapper;
import com.registro.registroelettronico.repository.SecretaryInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecretaryServiceImpl implements SecretaryService{
	
	private final SecretaryInfoRepository secretaryInfoRepository;
	private final SecretaryMapper secretaryMapper;
	
	
	@Override
	public UserResponseDTO createSecretary(SecretaryRequestDTO secretary, Credential credential) {
        SecretaryInfo secretaryInfo = secretaryMapper.toEntity(secretary);
        secretaryInfo.setCredential(credential);
        secretaryInfo = secretaryInfoRepository.save(secretaryInfo);
		return secretaryMapper.toUserResponse(secretaryInfo);
	}

	@Override
	public UserResponseDTO getSecretaryByCredentialId(UUID credentialId) {
		SecretaryInfo secretary = secretaryInfoRepository.findByCredentialId(credentialId)
				.orElseThrow(() -> new SecretaryNotFoundException(credentialId));
		return secretaryMapper.toUserResponse(secretary);
	}

}
