package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.ReprimandRequestDTO;
import com.registro.registroelettronico.dto.ReprimandResponseDTO;
import com.registro.registroelettronico.dto.StudentSummaryDTO;
import com.registro.registroelettronico.entity.Reprimand;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.entity.SubjectClass;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReprimandMapper {

    private final SubjectClassMapper subjectClassMapper;

    public ReprimandResponseDTO toDTO(Reprimand reprimand) {
        return ReprimandResponseDTO.builder()
                .id(reprimand.getId())
                .title(reprimand.getTitle())
                .message(reprimand.getMessage())
                .createdAt(reprimand.getCreatedAt())
                .student(
                        new StudentSummaryDTO(reprimand.getStudent().getId(), reprimand.getStudent().getFirstName(), reprimand.getStudent().getLastName()))
                .subjectClass(
                        subjectClassMapper.toDTO(reprimand.getSubjectClass())
                )
                .build();
    }

    public Reprimand toEntity(ReprimandRequestDTO request, StudentInfo student, SubjectClass subjectClass) {
        return Reprimand.builder()
                .student(student)
                .subjectClass(subjectClass)
                .title(request.getTitle())
                .message(request.getMessage())
                .createdAt(request.getCreatedAt())
                .build();
    }
}
