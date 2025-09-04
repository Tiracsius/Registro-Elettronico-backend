package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.JustificationRequestDTO;
import com.registro.registroelettronico.dto.JustificationResponseDTO;
import com.registro.registroelettronico.entity.Justification;
import com.registro.registroelettronico.entity.PresenceRecord;
import org.springframework.stereotype.Component;

@Component
public class JustificationMapper {

    public JustificationResponseDTO toDTO(Justification justification) {
        return JustificationResponseDTO.builder()
                .id(justification.getId())
                .message(justification.getMessage())
                .createdAt(justification.getCreatedAt())
                .build();
    }

    public Justification toEntity(JustificationRequestDTO request, PresenceRecord presenceRecord) {
        return Justification.builder()
                .createdAt(request.getCreatedAt())
                .message(request.getMessage())
                .presenceRecord(presenceRecord)
                .build();
    }
}
