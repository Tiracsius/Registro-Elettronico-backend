package com.registro.registroelettronico.mapper;

import com.registro.registroelettronico.dto.SecretaryRequestDTO;
import com.registro.registroelettronico.dto.UserResponseDTO;
import com.registro.registroelettronico.entity.SecretaryInfo;
import com.registro.registroelettronico.enums.UserRole;

import org.springframework.stereotype.Component;

@Component
public class SecretaryMapper {

    public SecretaryInfo toEntity(SecretaryRequestDTO request) {
        return SecretaryInfo.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
    
    public UserResponseDTO toUserResponse(SecretaryInfo secretary) {
    	return UserResponseDTO.builder()
    			.id(secretary.getId())
    			.firstName(secretary.getFirstName())
				.lastName(secretary.getLastName())
				.role(UserRole.SECRETARY)
				.email(secretary.getEmail())
				.build();
    }
}
