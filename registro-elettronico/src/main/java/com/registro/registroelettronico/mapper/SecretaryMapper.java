package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.SecretaryRequestDTO;
import com.registro.registroelettronico.entity.SecretaryInfo;
import org.springframework.stereotype.Component;

@Component
public class SecretaryMapper {

    public SecretaryInfo toEntity(SecretaryRequestDTO request) {
        return SecretaryInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
}
