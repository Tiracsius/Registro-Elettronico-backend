package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.VoteRecordRequestDTO;
import com.registro.registroelettronico.dto.VoteRecordResponseDTO;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.entity.SubjectClass;
import com.registro.registroelettronico.entity.VoteRecord;
import org.springframework.stereotype.Component;

@Component
public class VoteRecordMapper {

    public VoteRecord toEntity(VoteRecordRequestDTO request, StudentInfo student, SubjectClass subjectClass) {
        return VoteRecord.builder()
                .student(student)
                .vote(request.getVote())
                .subjectClass(subjectClass)
                .createdAt(request.getDate().toLocalDate())
                .build();
    }

    public VoteRecordResponseDTO toDTO(VoteRecord voteRecord) {
        return VoteRecordResponseDTO.builder()
                .id(voteRecord.getId())
                .vote(voteRecord.getVote())
                .subject(voteRecord.getSubjectClass().getSubject().getName())
                .createdAt(voteRecord.getCreatedAt())
                .build();
    }
}
