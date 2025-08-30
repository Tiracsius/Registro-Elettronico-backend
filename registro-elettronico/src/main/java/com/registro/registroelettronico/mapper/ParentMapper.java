package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.ParentRequestDTO;
import com.registro.registroelettronico.entity.ParentInfo;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper {

    public ParentInfo toEntity(ParentRequestDTO request) {
        return ParentInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

    }
}
