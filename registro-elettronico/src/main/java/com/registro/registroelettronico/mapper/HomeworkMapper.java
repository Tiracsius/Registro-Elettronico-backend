package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.HomeworkRequestDTO;
import com.registro.registroelettronico.dto.HomeworkResponseDTO;
import com.registro.registroelettronico.entity.Homework;
import com.registro.registroelettronico.entity.SubjectClass;
import org.springframework.stereotype.Component;

@Component
public class HomeworkMapper {

    public HomeworkResponseDTO toDTO(Homework homework) {
        return HomeworkResponseDTO.builder()
                .id(homework.getId())
                .message(homework.getMessage())
                .subjectClassId(homework.getSubjectClass().getId())
                .dueDate(homework.getDueDate())
                .createdAt(homework.getCreatedAt())
                .build();
    }

    public Homework toEntity(HomeworkRequestDTO request, SubjectClass subjectClass) {
        return Homework.builder()
                .message(request.getMessage())
                .dueDate(request.getDueDate())
                .createdAt(request.getCreatedAt())
                .subjectClass(subjectClass)
                .build();
    }
}
