package com.registro.registroelettronico.mapper;

import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.ClassSummaryDTO;
import com.registro.registroelettronico.dto.SubjectClassResponseDTO;
import com.registro.registroelettronico.dto.SubjectSummaryDTO;
import com.registro.registroelettronico.dto.TeacherSummaryDTO;
import com.registro.registroelettronico.entity.SubjectClass;

@Component
public class SubjectClassMapper {
	
	public SubjectClassResponseDTO toDTO(SubjectClass subjectClass) {
		 return new SubjectClassResponseDTO(
				 subjectClass.getId(),
		            new ClassSummaryDTO(subjectClass.getSchoolClass().getId(), subjectClass.getSchoolClass().getName()),
		            new SubjectSummaryDTO(subjectClass.getSubject().getName()),
		            new TeacherSummaryDTO(subjectClass.getTeacher().getId(), subjectClass.getTeacher().getFirstName(),subjectClass.getTeacher().getLastName())
		        );
	}
}
