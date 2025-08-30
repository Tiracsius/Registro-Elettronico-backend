package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.StudentRequestDTO;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.entity.StudentInfo;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentInfo toEntity(StudentRequestDTO request, ParentInfo parent, SchoolClass schoolClass) {
        return StudentInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .parent(parent)
                .schoolClass(schoolClass)
                .birthDate(request.getBirthDate())
                .build();
    }
}
