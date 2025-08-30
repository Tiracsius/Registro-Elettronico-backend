package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.StudentRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.ParentInfo;
import com.registro.registroelettronico.entity.SchoolClass;
import com.registro.registroelettronico.entity.StudentInfo;
import com.registro.registroelettronico.enums.UserRole;

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
    
    public UserResponseDTO toUserResponse(StudentInfo student) {
    	 return UserResponseDTO.builder()
    			 .id(student.getId())
    			 .firstName(student.getFirstName())
    			 .lastName(student.getLastName())
    			 .role(UserRole.STUDENT)
    			 .email(student.getEmail()).build();
    }
}
