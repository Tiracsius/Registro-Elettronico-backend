package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.TeacherRequestDTO;
import com.registro.registroelettronico.entity.TeacherInfo;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherInfo toEntity(TeacherRequestDTO request) {
        return TeacherInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
}
