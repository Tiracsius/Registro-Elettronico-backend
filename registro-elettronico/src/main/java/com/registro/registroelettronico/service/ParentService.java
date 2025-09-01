package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.ParentRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;

import java.util.List;
import java.util.UUID;

public interface ParentService {

    public List<UserResponseDTO> getAllParents();
    public UserResponseDTO getParentById(UUID id);
    public UserResponseDTO getParentByCredentialId(UUID credentialId);
    public UserResponseDTO createParent(ParentRequestDTO parent, Credential credential);

}