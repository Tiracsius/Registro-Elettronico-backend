package com.registro.registroelettronico.mapper;

import org.springframework.stereotype.Component;

import com.registro.registroelettronico.dto.TeacherRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.TeacherInfo;
import com.registro.registroelettronico.enums.UserRole;

@Component
public class TeacherMapper {

    public TeacherInfo toEntity(TeacherRequestDTO request) {
        return TeacherInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
    
    public UserResponseDTO toUserResponse(TeacherInfo teacher) {
    	return UserResponseDTO.builder()
    			.id(teacher.getId())
    			.firstName(teacher.getFirstName())
				.lastName(teacher.getLastName())
				.role(UserRole.TEACHER)
				.email(teacher.getEmail())
				.build();
    }
}
