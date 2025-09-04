package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.PresenceRecordRequestDTO;
import com.registro.registroelettronico.dto.PresenceRecordResponseDTO;
import com.registro.registroelettronico.dto.StudentSummaryDTO;
import com.registro.registroelettronico.entity.PresenceRecord;
import com.registro.registroelettronico.entity.StudentInfo;
import org.springframework.stereotype.Component;

@Component
public class PresenceRecordMapper {
    public PresenceRecordResponseDTO toDTO(PresenceRecord presenceRecord) {
        return PresenceRecordResponseDTO.builder()
                .id(presenceRecord.getId())
                .date(presenceRecord.getCreatedAt())
                .status(presenceRecord.getStatus())
                .student(new StudentSummaryDTO(
                        presenceRecord.getStudent().getId(),
                        presenceRecord.getStudent().getFirstName(),
                        presenceRecord.getStudent().getLastName()))
                .build();
    }

    public PresenceRecord toEntity(PresenceRecordRequestDTO request, StudentInfo student) {
        return PresenceRecord.builder()
                .student(student)
                .status(request.getStatus())
                .createdAt(request.getDate())
                .build();
    }
}
