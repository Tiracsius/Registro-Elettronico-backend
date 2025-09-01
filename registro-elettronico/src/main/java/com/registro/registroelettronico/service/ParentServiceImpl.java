package com.registro.registroelettronico.service;

import com.registro.registroelettronico.dto.ParentRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.Credential;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.exception.ParentNotFoundException;
import com.registro.registroelettronico.mapper.ParentMapper;
import com.registro.registroelettronico.repository.ParentInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService{


    private final ParentInfoRepository parentInfoRepository;
    private final ParentMapper parentMapper;

    @Override
    public List<UserResponseDTO> getAllParents() {
        List<UserResponseDTO> parents = parentInfoRepository.findAll()
                .stream()
                .map(parentMapper::toUserResponse)
                .toList();
        return parents;
    }

    @Override
    public UserResponseDTO getParentById(UUID id) {
        ParentInfo parent = parentInfoRepository.findById(id)
                .orElseThrow(() -> new ParentNotFoundException(id));
        return parentMapper.toUserResponse(parent);
    }

    @Override
    public UserResponseDTO getParentByCredentialId(UUID credentialId) {
        ParentInfo parent = parentInfoRepository.findByCredentialId(credentialId)
                .orElseThrow(() -> new ParentNotFoundException(credentialId));
        return parentMapper.toUserResponse(parent);
    }

    @Override
    public UserResponseDTO createParent(ParentRequestDTO parent, Credential credential) {
        ParentInfo parentInfo = parentMapper.toEntity(parent);
        parentInfo.setCredential(credential);
        parentInfo = parentInfoRepository.save(parentInfo);
        return parentMapper.toUserResponse(parentInfo);
    }

}
