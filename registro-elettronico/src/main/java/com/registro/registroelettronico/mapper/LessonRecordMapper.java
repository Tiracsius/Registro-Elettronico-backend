package com.registro.registroelettronico.mapper;

import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.LessonRecordRequestDTO;
import com.registro.registroelettronico.dto.LessonRecordResponseDTO;
import com.registro.registroelettronico.entity.LessonRecord;
import com.registro.registroelettronico.entity.SubjectClass;

@Component
public class LessonRecordMapper {
	
	public LessonRecordResponseDTO toDTO(LessonRecord lessonRecord) {
        return LessonRecordResponseDTO.builder()
                .id(lessonRecord.getId())
                .subjectClassId(lessonRecord.getSubjectClass().getId())
                .message(lessonRecord.getMessage())
                .date(lessonRecord.getCreatedAt())
                .build();
	}
	
	

    public LessonRecord toEntity(LessonRecordRequestDTO request, SubjectClass subjectClass) {
        return LessonRecord.builder()
                .subjectClass(subjectClass)
                .message(request.getMessage())
                .createdAt(request.getDate())
                .build();
    }
}
